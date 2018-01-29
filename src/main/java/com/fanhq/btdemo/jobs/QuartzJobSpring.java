package com.fanhq.btdemo.jobs;

import com.fanhq.btdemo.service.impl.MyService1;
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
        MyService1 myService = (MyService1)dataMap.get("myService");
        myService.say();
    }
}

