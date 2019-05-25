package com.fei.firstspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/5/22
 * @Description: 测试Controller
 */
@RestController
public class Mycontroller {

    @RequestMapping("hello")
    public String hello() {
        System.out.println("hello...来了");
        return "hello";
    }
}
