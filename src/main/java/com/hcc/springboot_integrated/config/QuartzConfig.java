package com.hcc.springboot_integrated.config;

import com.hcc.springboot_integrated.task.MyAdaptableJobFactory;
import com.hcc.springboot_integrated.task.MySpringBeanJobFactory;
import com.hcc.springboot_integrated.task.QuartzTask;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * Quartz配置类
 *
 * @ClassName QuartzConfig
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/7 11:46
 * @Version 1.0
 **/
@SpringBootConfiguration
public class QuartzConfig {

    //1.创建Job对象
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        //指定自己的job类
        jobDetailFactoryBean.setJobClass(QuartzTask.class);

        return jobDetailFactoryBean;
    }

    //2.创建Trigger对象
    //---简单的Trigger
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        //关联JobDetail对象
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //重复时间间隔2秒
        simpleTriggerFactoryBean.setRepeatInterval(2000);
        //重复次数
        simpleTriggerFactoryBean.setRepeatCount(5);
        return simpleTriggerFactoryBean;
    }


    //---Cron Trigger
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        //关联JobDetail对象
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //设置触发时间
        cronTriggerFactoryBean.setCronExpression("0/3 * * * * ?");
        return cronTriggerFactoryBean;
    }

    //3.创建Scheduler对象
//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean) {
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        //关联Trigger
//        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
//        return schedulerFactoryBean;
//    }

    //    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean1(CronTriggerFactoryBean cronTriggerFactoryBean) {
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        //关联Trigger
//        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
//        return schedulerFactoryBean;
//    }
    //Job类对象注入Ioc修改的
//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean1(CronTriggerFactoryBean cronTriggerFactoryBean, MyAdaptableJobFactory myAdaptableJobFactory) {
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        //关联Trigger
//        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
//        schedulerFactoryBean.setJobFactory(myAdaptableJobFactory);////
//        return schedulerFactoryBean;
//    }

    //另一种Job类对象注入Ioc修改的
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean1(CronTriggerFactoryBean cronTriggerFactoryBean, MySpringBeanJobFactory myAdaptableJobFactory) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //关联Trigger
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        schedulerFactoryBean.setJobFactory(myAdaptableJobFactory);////
        return schedulerFactoryBean;
    }
}
