package com.fanhq.btdemo.config;

import com.fanhq.btdemo.scheduler.MyScheduler;
import com.fanhq.btdemo.service.MyService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hachel on 2018/1/25
 */
@Configuration
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MyScheduler myScheduler;

    @Autowired
    private MyService myService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            myScheduler.scheduleJobs();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        Map<String, Object> springBeanMap = new HashMap<String, Object>();
        springBeanMap.put("myService", myService);
        schedulerFactoryBean.setSchedulerContextAsMap(springBeanMap);
        return schedulerFactoryBean;
    }
}
