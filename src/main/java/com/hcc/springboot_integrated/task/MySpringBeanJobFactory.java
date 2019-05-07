package com.hcc.springboot_integrated.task;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

/**
 * 另一种Job对象注入到IOC
 * 继承AdaptableJobFactory类或者SpringBeanJobFactory类，都可以
 *
 * @ClassName MySpringBeanJobFactory
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/7 15:06
 * @Version 1.0
 **/
@Component
public class MySpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

    private transient AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {

        autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
    }

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object obj = super.createJobInstance(bundle);
        autowireCapableBeanFactory.autowireBean(obj);
        return obj;
    }
}
