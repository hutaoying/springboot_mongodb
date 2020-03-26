package com.one.springboot_mongodb.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程异常捕获案例
 */
public class Demo1 {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new ThreadExceptionRunner());
            thread.start();
        } catch (Exception e) {
            System.out.println("========");
            e.printStackTrace();
        } finally {
        }
        System.out.println(123);
        ExecutorService exec = Executors.newCachedThreadPool(new HandleThreadFactory());
        exec.execute(new ThreadExceptionRunner());
//        exec.shutdown();

    }
    public static void incre(){
        atomicInteger.incrementAndGet();
        System.out.println("aa");
    }
}
//@Slf4j
class MyUncaughtExceptionHandle implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
//        log.info("COUGHT:{},e:{}",t.getName(),e);
        System.out.println("caught " + e);
        System.out.println("t name " + e);
    }
}

class HandleThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println("create thread t");
        Thread t = new Thread(r);
        System.out.println("set uncaughtException for t");
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandle());
        return t;
    }
}


