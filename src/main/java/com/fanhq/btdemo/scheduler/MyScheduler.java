package com.fanhq.btdemo.scheduler;

import com.fanhq.btdemo.jobs.QuartzJobSpring;
import com.fanhq.btdemo.service.MyService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by Hachel on 2018/1/25
 */
@Component
public class MyScheduler {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private MyService myService;


    public void scheduleJobs() throws SchedulerException {
        //调度器
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        startJob(scheduler);
    }

    private void startJob(Scheduler scheduler) throws SchedulerException {
        //任务
        JobDataMap dataMap = new JobDataMap();
        dataMap.put("myService", myService);
        JobDetail jobDetail = JobBuilder.newJob(QuartzJobSpring.class)
                .withIdentity("job", "group").setJobData(dataMap).build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
}
