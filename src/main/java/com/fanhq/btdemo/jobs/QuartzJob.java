package com.fanhq.btdemo.jobs;

import com.fanhq.btdemo.service.MyService;
import org.quartz.*;

/**
 * Created by Hachel on 2018/1/25
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class QuartzJob implements Job {
    

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        MyService myService = (MyService)dataMap.get("myService");
        myService.say();
    }
}

