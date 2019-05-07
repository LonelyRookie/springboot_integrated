package com.hcc.springboot_integrated;

import com.hcc.springboot_integrated.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Redis测试
 *
 * @ClassName RedisTest
 * @Description spring data redis 测试
 * @Author Abel
 * @Date 2019/5/4 16:23
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void setTest() {
        this.redisTemplate.opsForValue().set("key", "我遇上对的人");
    }

    @Test
    public void getTest() {
        String key = (String) this.redisTemplate.opsForValue().get("key");
        System.out.println(key);
    }

    @Test
    public void setUserTest() {
        User user = new User();
        user.setUserId(11);
        user.setName("xiaoxiao");
        user.setAge(20);
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        this.redisTemplate.opsForValue().set("user", user);
    }

    @Test
    public void getUserTest() {
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        User user = (User) this.redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }

    //以json格式存储
    @Test
    public void setUserJsonTest() {
        User user = new User();
        user.setUserId(22);
        user.setName("abel");
        user.setAge(23);
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        this.redisTemplate.opsForValue().set("user_json", user);
    }

    @Test
    public void getUserJsonTest() {
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        User user = (User) this.redisTemplate.opsForValue().get("user_json");
        System.out.println(user);
    }

}
