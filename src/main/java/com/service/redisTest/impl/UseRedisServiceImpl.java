package com.service.redisTest.impl;

import com.alibaba.fastjson.JSON;
import com.dao.pojo.login.LoginDataDO;
import com.service.redisTest.UseRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Service
public class UseRedisServiceImpl implements UseRedisService {
    private final static String  USER_REDIS_KEY = "user:";

    @Autowired
//    private RedisTemplate<String,String> redisTemplate;
    private RedisTemplate redisTemplate;

    @Override
    public String saveUser(String name, String user, String password) {
        Map<String, String > userMap = new HashMap<>();
        userMap.put("name", name);
        userMap.put("user", user);
        userMap.put("password", password);
//        String useString = JSON.toJSONString(userMap);
        String saveSuccess = "success";
        try {
            redisTemplate.opsForValue().set(USER_REDIS_KEY, userMap);
        } catch (Exception e) {
            saveSuccess = "error";
        }
        return saveSuccess;
    }
}
