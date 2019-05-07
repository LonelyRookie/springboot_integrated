package com.hcc.springboot_integrated;

import com.hcc.springboot_integrated.mapper.UserMapper;
import com.hcc.springboot_integrated.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName UserMapperTest
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/7 22:12
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insertUserTest() {
        User user = new User();
        user.setName("奇尼奇");
        user.setAge(23);
        user.setGender("男");
        userMapper.insertUser(user);

    }
}
