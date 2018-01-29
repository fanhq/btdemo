package com.fanhq.btdemo.jobs;

import com.fanhq.btdemo.service.impl.MyService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Hachel on 2018/1/29
 */

@Component
public class SpringJobs {


    @Autowired
    private MyService3 myService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void job(){
        myService.say();
    }

}
