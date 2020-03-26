package com.one.springboot_mongodb.lock;

public class Main {
    public static void main(String[] args) {
        //3个生产者  3个消费者
        ProCon storage = new ProCon();
        Thread p1 = new Thread(new Pro(storage));
        Thread p2 = new Thread(new Pro(storage));
        Thread p3 = new Thread(new Pro(storage));

        Thread c1 = new Thread(new ConS(storage));
        Thread c2 = new Thread(new ConS(storage));
        Thread c3 = new Thread(new ConS(storage));

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();


    }
}
