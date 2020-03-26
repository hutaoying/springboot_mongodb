package com.one.springboot_mongodb.lock;

/**
 *
 * tips: 死锁状态无法被中断
 */
public class TestInter {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                //使用thread.interrupt()中断非阻塞线程
//                while(true){
//                    if (Thread.currentThread().isInterrupted()){
//                        System.out.println("exit MyThread");
//                        break;
//                    }
//                    System.out.println("aa");
//                }


                //使用thread.interrupt()中断阻塞状态线程
                // Thread.interrupt()方法不会中断一个正在运行的线程。
                // 这一方法实际上完成的是，设置线程的中断标示位，
                // 在线程受到阻塞的地方（如调用sleep、wait、join等地方）抛出一个异常
                while (true){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        /*
                         * 如果线程在调用 Object.wait()方法，或者该类的 join() 、sleep()方法
                         * 过程中受阻，则其中断状态将被清除
                         */
                        System.out.println(this.isInterrupted());// false

                    }
                }

            }
        };
        t.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        t.interrupt();
        System.out.println("main" +t.isInterrupted());
    }

}
