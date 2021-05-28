package com.controller;

import com.dao.pojo.RegisterInfo;
import com.service.impl.RegisterInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RequestMapping("/userInfo")
public class RegisterInfoController {
    @Autowired
    RegisterInfoServiceImpl registerInfoServiceImpl;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @GetMapping("/registerInfo")
    public List<RegisterInfo> getAccountList() {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        System.out.println(operations.get("abc"));
        return registerInfoServiceImpl.getAccoutList();
    }

    @ResponseBody
    @GetMapping("/registerInfoOne")
    public RegisterInfo getAccount(String phone) {
        return registerInfoServiceImpl.getAccout(phone);
    }

    @ResponseBody
    @PostMapping("/registerInfo")
    public int saveAccountList(@RequestBody RegisterInfo registerInfo) {
        System.out.println(registerInfo);
        int result = registerInfoServiceImpl.insertAccount(registerInfo);
        // 如果保存成功, 则返回id最后保存的id值
        if (result == 1) {
            return registerInfo.getUserId();
        } else {
            return result;
        }
    }
//    @ResponseBody
//    @GetMapping("/registerInfo")
//    public List<RegisterInfo> getRegisterInfoList() {
//
//    }
}
