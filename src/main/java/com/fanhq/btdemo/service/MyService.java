package com.fanhq.btdemo.service;

import org.springframework.stereotype.Component;

/**
 * Created by Hachel on 2018/1/25
 */

@Component(value = "myService")
public class MyService {

   public void sayHello(){
       System.out.println("hello");
   }

}
