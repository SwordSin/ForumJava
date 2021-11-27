package com.controller.login;

import com.common.ResultWapper;
import com.dao.pojo.login.LoginDataDO;
import com.dao.pojo.login.RegisterInfo;
import com.service.login.impl.RegisterInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/userInfo")
public class RegisterInfoController {
    @Autowired
    RegisterInfoServiceImpl registerInfoServiceImpl;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    // 获取redis中的数据
    @ResponseBody
    @GetMapping("/registerInfo")
    public List<RegisterInfo> getAccountList() {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        System.out.println(operations.get("abc"));
        return registerInfoServiceImpl.getAccoutList();
    }

    // 注册用户
    @ResponseBody
    @PostMapping("/registerInfo")
    public ResultWapper<String> saveAccountList(@RequestBody RegisterInfo registerInfo, HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) {
        return registerInfoServiceImpl.insertAccount(registerInfo);
    }

    // 登录
    @ResponseBody
    @PostMapping("/login")
    public ResultWapper<RegisterInfo> login(@RequestBody LoginDataDO loingDataDO, HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) {
        // int state
        return registerInfoServiceImpl.loginVerify(loingDataDO, httpRequest, httpServletResponse);
    }

    // 获取昵称
    @ResponseBody
    @GetMapping("/getOneAccountKey")
    public String getOneAccountKey(String queryKey, String queryValue, String resultKey) {
        return registerInfoServiceImpl.getAccountOne(resultKey, queryKey, queryValue).getNetName();
    }

}
