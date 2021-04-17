package com;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

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
//    RedisTemplate redisTemplate;

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void redisTest() {
//        ValueOperations<String , String > valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("aaa", "bbb");
    }
}
