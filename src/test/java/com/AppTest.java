package com;

import static org.junit.Assert.assertTrue;

import com.config.RedisConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.servlet.http.PushBuilder;

/**
 * Unit test for simple App.
 */

@Component
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

//    @Autowired
//    StringRedisTemplate redisTemplate;
//
//    @Autowired
//    RedisConfig redisConfig;

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void redisTest() {
//        redisTemplate.opsForValue();

//        redisConfig.getName();
    }
    @Test
    public void getHash() {
//        Integer a = 12;
        String a = "aaa";
        int test = (a.hashCode()) ^ (a.hashCode() >>> 16);
        System.out.println(a.hashCode());
        System.out.println(13 >>> 16);
        System.out.println(test);
    }

//    @Test
//    public void redisTest() {}


}
