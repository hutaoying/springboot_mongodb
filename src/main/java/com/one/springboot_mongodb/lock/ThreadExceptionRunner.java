package com.one.springboot_mongodb.lock;

public class ThreadExceptionRunner implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("error !!!!");
    }
}
