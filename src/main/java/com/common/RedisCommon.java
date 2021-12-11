package com.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.models.auth.In;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

// 操作redis的共同函数
@Component
public class RedisCommon<T> {
    @Resource
    private RedisTemplate redisTemplate;

    // 保存redis
    public Integer saveRedis(String key, T t) {
        String objStr = JSON.toJSONString(t);
        int isSuccess = 1;
        try {
            redisTemplate.opsForValue().set(key, objStr);
        } catch (Exception e) {
            isSuccess = 0;
        }
        return isSuccess;
    }

    // 获取redis, 如果不存在返回null
    public T getRedis(String key, Class<T> tClass) {
        Object result = redisTemplate.opsForValue().get(key);
        if(result == null) {
            return null;
        } else {
            return JSONObject.parseObject((String) result, tClass);
        }
    }

    // 保存redi list
    public Integer saveRedisList(String key, String value) {
        int isSuccess = 1;
        try {
            redisTemplate.opsForList().leftPush(key,value);
        } catch (Exception e) {
            isSuccess = 0;
        }
        return isSuccess;
    }

    // 删除redis list
    public Integer delRedisList(String key, String  value) {
        int isSuccess = 1;
        try {
            redisTemplate.opsForList().remove(key, 0 , value);
        } catch (Exception e) {
            isSuccess = 0;
        }
        return isSuccess;
    }

    // 存储hash值
    public Integer saveRedisSaveHash(String key, String fidle, String value) {
        int isSuccess = 1;
        try {
            redisTemplate.opsForHash().put(key, fidle, value);
        } catch (Exception e) {
            isSuccess = 0;
        }
        return isSuccess;
    }

    // 查看某个hash值是否存在
    public Boolean hasRedisHashKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

}
