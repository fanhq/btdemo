package com.fanhq.btdemo.jobs;

import com.fanhq.btdemo.service.MyService;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * Created by Hachel on 2018/1/25
 */

@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class QuartzJobSpring extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        MyService myService = (MyService)dataMap.get("myService");
        myService.sayHello();
    }
}

