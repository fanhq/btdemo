package com.fanhq.btdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Hachel on 2018/3/13
 */
@Controller
@RequestMapping(value = "demo")
public class DemoController {

    private static ReentrantLock lock = new ReentrantLock();

    @RequestMapping(value = "hello")
    @ResponseBody
    public String hello(String key) {
        System.out.println(key);
        System.out.println("-----");
        return "hi";
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(String key) {
        System.out.println(key);
        System.out.println("-----");
        return "hi";
    }
}
