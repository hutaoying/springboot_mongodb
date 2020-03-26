package com.one.springboot_mongodb.interrup;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Example3 extends Thread {
    public static void main(String args[]) throws Exception {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
//        final Object lock1 = new Object();
//        final Object lock2 = new Object();
        Thread thread1 = new Thread() {
            public void run() {
                deathLock(lock1, lock2);
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                // 注意，这里在交换了一下位置
                deathLock(lock2, lock1);
            }
        };
        System.out.println("Starting thread...");
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        System.out.println("Interrupting thread...");
        thread1.interrupt();
        thread2.interrupt();
        Thread.sleep(3000);
        System.out.println("Stopping application...");
    }

    static void deathLock(Lock lock1, Lock lock2) {
        try {
//            lock1.lockInterruptibly();
            lock1.lock();
            Thread.sleep(10);
//            lock2.lockInterruptibly(); 死锁可响应中断
            lock2.lock();
//            synchronized (lock1) {
//                Thread.sleep(10);// 不会在这里死掉
//                synchronized (lock2) {// 会锁在这里，虽然阻塞了，但不会抛异常
//                    System.out.println(Thread.currentThread());
//                }
//            }
        } catch (InterruptedException e) {
            System.out.println("inter" + Thread.currentThread().getId());
            e.printStackTrace();
            System.exit(1);
        }
    }
}