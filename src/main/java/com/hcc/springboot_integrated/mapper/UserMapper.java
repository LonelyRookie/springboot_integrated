package com.hcc.springboot_integrated.mapper;

import com.hcc.springboot_integrated.pojo.User;

/**
 * 集成mybatis
 *
 * @ClassName UserMapper
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/7 20:55
 * @Version 1.0
 **/
public interface UserMapper {

    int insertUser(User user);
}
