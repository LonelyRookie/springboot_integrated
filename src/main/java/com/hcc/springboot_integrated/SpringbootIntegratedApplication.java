package com.hcc.springboot_integrated;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@EnableScheduling  //开启任务定时
@ServletComponentScan //@ServletComponentScan 在springBoot 启动时会扫描@WebServlet,@WebListener,@WebFilter，并将该类实例化
@MapperScan("com.hcc.springboot_integrated.mapper")//扫描MyBatis的Mapper接口
public class SpringbootIntegratedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootIntegratedApplication.class, args);
    }

}
