package com.hcc.springboot_integrated.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置类
 *
 * @ClassName RedisConfig
 * @Description 整合Redis的配置, 基于springboot2.0
 * @Author Abel
 * @Date 2019/5/4 14:39
 * @Version 1.0
 **/
@Configuration
@EnableCaching ///继承CachingConfigurerSupport并重写方法，配合该注解实现spring缓存框架的使用
public class RedisConfig extends CachingConfigurerSupport {

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory) {//springboot1.5 jedis连接池
//        //配置序列化
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//
//        //配置redisTemplate
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
//        redisTemplate.setConnectionFactory(factory);
//
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer); // key序列化
//        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer); // value序列化
//        redisTemplate.setHashKeySerializer(stringSerializer); // Hash key序列化
//        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer); // Hash value序列化
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {//springboot2.0默认lettuce连接池
        //配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);
        //设置序列化器
        //key序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //value序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        //value hashmap序列化
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer(Object.class));

        return redisTemplate;

    }

    @Override
    public KeyGenerator keyGenerator() {
//        设置自动key的生成规则，配置spring boot的注解，进行方法级别的缓存
//        使用":"进行分割，可以很多显示出层级关系


//       return  new KeyGenerator(){
//
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(target.getClass().getName());
//                sb.append(":");
//                sb.append(method.getName());
//                for (Object obj : params) {
//                    sb.append(":" + String.valueOf(obj));
//                }
//                return sb.toString();
//            }
//        };
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(":");
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(":" + String.valueOf(obj));
            }
            return sb.toString();
        };

    }

    @Override
    public CacheManager cacheManager() {
        //可以设置缓存过期时间
        return super.cacheManager();
    }
}
