package com.one.springboot_mongodb.test;

public class Test {
    static Byte[] lock = new Byte[0];

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    static class Thread1 extends Thread {

        @Override
        public void run() {

                for (int i = 0; i < 100; i++) {
                    synchronized (lock) {
                        System.out.println(i);
                    }
                }
            }
        }


    static class Thread2 extends Thread {
        @Override
        public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (lock) {
                        System.out.println(-i);
                    }

                }
            }
        }


}
