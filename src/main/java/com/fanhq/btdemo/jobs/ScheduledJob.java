package com.fanhq.btdemo.jobs;

import com.fanhq.btdemo.service.MyService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

/**
 * Created by Hachel on 2018/1/25
 */
@DisallowConcurrentExecution
public class ScheduledJob implements Job {
    

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        MyService myService = (MyService)dataMap.get("myService");
        myService.sayHello();
    }
}

