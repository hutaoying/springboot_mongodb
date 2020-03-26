package com.one.springboot_mongodb.future;

import java.util.concurrent.Callable;

public class Task1 implements Callable {
    @Override
    public Object call() throws Exception {
        return "ss";
    }
}
