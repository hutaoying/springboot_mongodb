package com.one.springboot_mongodb.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {
    public synchronized  String pressureTest(){
        long threadId = Thread.currentThread().getId();
        log.info("currentThread---->:{}",threadId);
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "thread:"+threadId+"success";
    }
}
