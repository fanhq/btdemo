package com.fanhq.btdemo.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Hachel on 2018/1/25
 */
@DisallowConcurrentExecution
public class ScheduledJob implements Job {

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("HH:mm:ss");
    }

    @Override
    public void execute(JobExecutionContext context) {
        while (true) {
            System.out.println("begin: The time is now " + dateFormat().format(new Date()));
            try {
                System.out.println("before: The time is now " + dateFormat().format(new Date()));
                Thread.sleep(10000);
                System.out.println("after: The time is now " + dateFormat().format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end: The time is now " + dateFormat().format(new Date()));
        }
    }
}

