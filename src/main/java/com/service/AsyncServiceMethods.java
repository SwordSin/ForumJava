package com.service;

import com.alibaba.fastjson.JSONObject;
import com.common.RedisCommon;
import com.dao.forum.LoginLogMapper;
import com.dao.pojo.login.LoginLogDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
@Slf4j
public class AsyncServiceMethods {
    @Resource
    private LoginLogMapper loginLogMapper;
    @Resource
    private RedisCommon<LoginLogDO> redisCommonLoginDataDo;
    @Value(value = "${realIpKey}")
    private String realIpKey;


    @Async("scorePoolTaskExecutor")
    public Integer saveLoginLog(String username, Boolean rememberMe, HttpServletRequest req) {
        log.info("多线程添加login日志");
        LoginLogDO loginLogDO = new LoginLogDO();
        loginLogDO.setUsername(username);
        loginLogDO.setRememberMe(rememberMe);
        loginLogDO.setIp(req.getHeader(realIpKey));
        loginLogDO.setLoginDate(new Date());
        Integer saveStatus = loginLogMapper.insert(loginLogDO);
        // 判断是否保存成功
        if (saveStatus == 0) return 0;
        Long id = loginLogDO.getId();
        saveStatus = redisCommonLoginDataDo.saveRedis("loginlog:" + id, loginLogDO);
        return saveStatus;
    }

    @Async("scorePoolTaskExecutor")
    public Integer saveSessionInRedis(String sessionId, Object obj) {
        log.info("保存内容");

        return redisCommonLoginDataDo.saveRedisSaveHash("sessionIdHash", sessionId, JSONObject.toJSONString(obj));
    }



}
