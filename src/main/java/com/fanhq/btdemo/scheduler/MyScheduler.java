package com.fanhq.btdemo.scheduler;

import com.fanhq.btdemo.jobs.ScheduledJob;
import com.fanhq.btdemo.service.MyService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Hachel on 2018/1/25
 */
@Component
public class MyScheduler {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private List<MyService> myService;


    public void scheduleJobs() throws SchedulerException {
        //调度器
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        startJob(scheduler);
    }

    private void startJob(Scheduler scheduler) throws SchedulerException {
        //任务
        JobDataMap dataMap = new JobDataMap();
        dataMap.put("myService", myService.get(0));
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class)
                .withIdentity("jobName").setJobData(dataMap).build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("triggerName").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
}
