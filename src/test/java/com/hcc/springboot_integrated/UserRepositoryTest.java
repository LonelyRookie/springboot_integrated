package com.hcc.springboot_integrated;

import com.hcc.springboot_integrated.dao.UserRepository;
import com.hcc.springboot_integrated.pojo.Menu;
import com.hcc.springboot_integrated.pojo.Role;
import com.hcc.springboot_integrated.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * UserRepository接口测试
 *
 * @ClassName UserRepositoryTest
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/5 22:37
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * 一对多关联关系-----添加
     */
    @Test
    public void saveTest_OneToMany() {
        //创建用户
        User user = new User();
        user.setName("小丽");
        user.setAge(21);
        user.setGender("女");

        //创建角色
        Role role = new Role();
        role.setRoleName("管理员");

        //关联
        role.getUsers().add(user);
        user.setRole(role);

        this.userRepository.save(user);

        //实体类上有lombok的@Data注解会报错。执行到user.setRole(role)此步骤时。因为toString()方法的缘故
    }


    /**
     * 一对多关联关系-----查询
     */
    @Test
    public void findOneTest_OneToMany() {
        User user = new User();
        user.setUserId(1);
        Example<User> of = Example.of(user);
        Optional<User> optionalUser = this.userRepository.findOne(of);
        User user_result = optionalUser.get();
        System.out.println(user_result);
        Role role = user_result.getRole();
        System.out.println(role);
    }


    /**
     * 方法名称命名测试
     */
    @Test
    public void findByNameTest() {
        List<User> list = this.userRepository.findByName("小李");
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 方法名称命名测试
     */
    @Test
    public void findByNameAndAgeTest() {
        List<User> list = this.userRepository.findByNameAndAge("小李", 23);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 方法名称命名测试
     */
    @Test
    public void findByNameLikeTest() {
        List<User> list = this.userRepository.findByNameLike("小%");
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * @Query测试---索引参数
     */
    @Test
    public void queryByNameUseHQLTest() {
        List<User> list = this.userRepository.queryByNameUseHQL("小花");
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * @Query测试---索引参数
     */
    @Test
    public void queryByNameUseSQLTest() {
        List<User> list = this.userRepository.queryByNameUseSQL("小花");
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * @Query测试---索引参数
     */
    @Test
    @Transactional//@Transactional与@Test 一起使用时 事务是自动回滚的
    @Rollback(false) //取消自动回滚
    public void updateUserNameByIdTest() {
        int nameById = this.userRepository.updateUserNameById("张三", 1);
        System.out.println(nameById);
    }

    /**
     * Query测试---命名参数
     */
    @Test
    public void findIdAndNameTest() {
        List<User> idAndName = this.userRepository.findIdAndName(1, "张三");
        for (User user : idAndName) {
            System.out.println(user);
        }

    }


}
