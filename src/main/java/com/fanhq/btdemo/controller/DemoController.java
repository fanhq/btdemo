package com.fanhq.btdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;
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
    public String hello(@RequestParam("publicKey") String publicKey) {
        System.out.println(publicKey);
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return "1";
    }
}
