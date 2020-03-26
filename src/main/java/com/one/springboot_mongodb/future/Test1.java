package com.one.springboot_mongodb.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test1 {

    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(3);
        //submit方法有多重参数版本，及支持callable也能够支持runnable接口类型.
        Future future = e.submit(new Task1());
        future.isDone(); //return true,false 无阻塞
        try {
            future.get(); // return 返回值，阻塞直到该线程运行结束
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}
