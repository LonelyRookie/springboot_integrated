package com.hcc.springboot_integrated.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 整合Listener
 *
 * @ClassName FirstListener
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/7 16:25
 * @Version 1.0
 **/
@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Listener...init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Listener...destroy");
    }
}
