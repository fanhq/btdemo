package com.fanhq.btdemo.service.impl;

import com.fanhq.btdemo.service.MyService;
import org.springframework.stereotype.Component;

/**
 * Created by Hachel on 2018/1/25
 */

@Component
public class MyService1 implements MyService{

   public void sayHello(){
       System.out.println("hello");
   }

}
