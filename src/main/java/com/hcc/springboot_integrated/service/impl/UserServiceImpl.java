package com.hcc.springboot_integrated.service.impl;

import com.hcc.springboot_integrated.dao.UserRepository;
import com.hcc.springboot_integrated.pojo.User;
import com.hcc.springboot_integrated.service.UserService;
import com.hcc.springboot_integrated.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private UserRepository userRepository;

    @Override
    public void excute() {
        System.out.println("Quartz执行测试");
    }

    @CacheEvict(value = "users", allEntries = true)//清除缓存中以users缓存策略缓存的对象
    @Override
    public void addUser(User user) {
        System.out.println("添加用户");
        System.out.println(userMapper);
        this.userMapper.insertUser(user);
    }

    @Cacheable(value = "users")//对当前查询的对象做缓存处理,通过我们自定义的策略name="users",在ehcache.xml中
    @Override
    public List<User> findAll() {
        System.out.println("ehcache缓存。。。。。");
        return userRepository.findAll();
    }
}
