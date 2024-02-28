package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void setTest(){
        //在redis中存入一个键值对 StringRedisTemplate
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        operations.set("username","xqx");
    }

    public void getTest(){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        System.out.println(operations.get("username"));
    }
}
