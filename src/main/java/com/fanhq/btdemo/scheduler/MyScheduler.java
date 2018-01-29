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
        JobDataMap dataMap1 = new JobDataMap();
        dataMap1.put("myService", myService.get(0));
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class).setJobData(dataMap1).build();
        //触发器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();
        //调度器
        scheduler.scheduleJob(jobDetail, cronTrigger);

        //任务
        JobDataMap dataMap2 = new JobDataMap();
        dataMap2.put("myService", myService.get(1));
        JobDetail jobDetail2 = JobBuilder.newJob(ScheduledJob.class).setJobData(dataMap2).build();
        //触发器
        CronScheduleBuilder scheduleBuilder2 = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        CronTrigger cronTrigger2 = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder2).build();
        //调度器
        scheduler.scheduleJob(jobDetail2, cronTrigger2);
    }
}
