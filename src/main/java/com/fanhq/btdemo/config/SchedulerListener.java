package com.fanhq.btdemo.config;

import com.fanhq.btdemo.scheduler.MyScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by Hachel on 2018/1/25
 */
@Configuration
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MyScheduler myScheduler;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            myScheduler.scheduleJobs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        return schedulerFactoryBean;
    }
}
