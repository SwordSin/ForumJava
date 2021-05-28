package com.config;


import ch.qos.logback.classic.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisConfig {
    private int age;
    private String name;
    RedisConfig() {
        this.age = 12;
        this.name = "aaa";
    }

    public int getAge() {
        return age;
    }
}
