package com.hcc.springboot_integrated.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * spring自带的 Scheduled 定时任务器
 *
 * @ClassName ScheduledTask
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/7 13:26
 * @Version 1.0
 **/
@Component
public class ScheduledTask {

    @Scheduled(initialDelay = 1000, fixedDelay = 2000)//服务器启动完毕后等1毫秒开始执行这个任务,每隔2毫秒运行一次定时任务
    public void firstTask() {
        System.out.println(new Date() + "第一个定时任务");
    }

    @Scheduled(cron = "0/3 * * * * ?")//每隔三秒运行有一次定时任务
    public void secondTask() {
        System.out.println(new Date() + "第二个定时任务");
    }
}
