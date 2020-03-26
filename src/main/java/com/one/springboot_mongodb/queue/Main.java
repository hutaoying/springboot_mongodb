package com.one.springboot_mongodb.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        int a=0;
        System.out.println(test());

//        System.out.println( Thread.interrupted());
//        System.out.println("bb");
    }
    public static int test(){
        int a =0;
        try {
            System.out.println("aa");
            return a=a+1;
        }finally {
            a=6;
        }

    }
}
