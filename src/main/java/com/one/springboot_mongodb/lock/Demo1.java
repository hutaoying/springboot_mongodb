package com.one.springboot_mongodb.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo1 {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        incre();
    }
    public static void incre(){
        atomicInteger.incrementAndGet();
        System.out.println("aa");
    }
}
