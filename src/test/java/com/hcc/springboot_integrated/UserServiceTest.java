package com.hcc.springboot_integrated;

import com.hcc.springboot_integrated.pojo.User;
import com.hcc.springboot_integrated.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName UserServiceTest
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/8 21:02
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void findAllTest() {
        List<User> all1 = userService.findAll();
        System.out.println(all1);

        List<User> all2 = userService.findAll();
        System.out.println(all2);
    }
}
