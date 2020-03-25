package com.one.springboot_mongodb.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;
@Service
@Slf4j
public class TestService2 {
    private static volatile AtomicBoolean flag = new AtomicBoolean(true);


    public String pressureTest() {
        long threadId = Thread.currentThread().getId();
        if (flag.compareAndSet(true, false)) {
            log.info("currentThread---->:{}", threadId);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                flag.set(true);
                return "thread:" + threadId + "success";
            }

        } else {
            return "thread:" + threadId + "FAILED";
        }
    }
}
