package com.one.springboot_mongodb.controller;

import com.one.springboot_mongodb.test.TestService;
import com.one.springboot_mongodb.test.TestService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    TestService testService;
    @Autowired
    TestService2 testService2;

    @GetMapping("/test1")
    public String test1() {
        return testService.pressureTest();

    }

    @GetMapping("/test2")
    public String test2() {
        return testService2.pressureTest();
    }
}
