package com.qqq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class quickController {

    @Value("${name}")
    private String name;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
    @RequestMapping("/name")
    public String name(){
        return name;
    }



}
