package com.hcc.springboot_integrated.service.impl;

import com.hcc.springboot_integrated.pojo.User;
import com.hcc.springboot_integrated.service.UserService;
import com.hcc.springboot_integrated.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/7 20:57
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    //mybatis
    @Autowired
    private UserMapper userMapper;

    @Override
    public void excute() {
        System.out.println("Quartz执行测试");
    }

    @Override
    public void addUser(User user) {
        System.out.println("添加用户");
        System.out.println(userMapper);
        this.userMapper.insertUser(user);
    }
}
