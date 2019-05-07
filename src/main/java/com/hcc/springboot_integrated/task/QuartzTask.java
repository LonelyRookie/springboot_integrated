package com.hcc.springboot_integrated.task;

import com.hcc.springboot_integrated.dao.UserRepository;
import com.hcc.springboot_integrated.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 集成Quartz 做定时任务
 *
 * @ClassName QuartzTask
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/7 13:45
 * @Version 1.0
 **/
public class QuartzTask implements Job {

    @Autowired
    private UserService userService;

    /**
     * 任务触发时被执行
     *
     * @param context
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Quartz执行任务" + new Date());
        this.userService.excute();//这里会抛出SchedulerException，空指针
        /**
         * 原因：Job类QuartzTask实例化时没有通过Ioc。而是通过反射实例化对象。
         * 查看AdaptableJobFactory类中的createJobInstance方法可知
         *
         * 解决:写类继承AdaptableJobFactory类，重写createJobInstance方法，手动将任务类QuartzTask添加到SpringIOC容器中
         */
    }
}
