package com.onefiter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.onefiter.service.HelloService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloController {
    @Reference
    private HelloService helloService;

    @RequestMapping("/hello")
    public String getName(String name){

        String result = helloService.sayHello(name);
        return result;
    }
}
