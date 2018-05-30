package com.fanhq.btdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Hachel on 2018/3/13
 */
@Controller
@RequestMapping(value = "demo")
public class DemoController {

    private static ReentrantLock lock = new ReentrantLock();
    /*
    流地址：rtmp://localhost/live/123343454366
     name：   123343454366
     pageUrl：   null
     tcUrl：   null
     swfUrl：  null
     flashVer：   null
     app：  live
     clientid：   5 7 9......
     addr：  127.0.0.1
     call：   publish
     */

    @RequestMapping(value = "hello", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String hello(HttpServletRequest request) {
        System.out.println("-----");
        Enumeration em = request.getParameterNames();
        while (em.hasMoreElements()) {
            String name1 = (String) em.nextElement();
            String value = request.getParameter(name1);
            System.out.println(name1 + ":" + value);
        }
        System.out.println("-----");
        return "hi";
    }

    @RequestMapping(value = "update", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String update(HttpServletRequest request) {
        System.out.println("-----");
        Enumeration em = request.getParameterNames();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getParameter(name);
            System.out.println(name + ":" + value);
        }
        System.out.println("-----");
        return "hi";
    }
}
