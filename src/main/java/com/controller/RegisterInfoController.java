package com.controller;

import com.dao.pojo.RegisterInfo;
import com.service.impl.RegisterInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userInfo")
public class RegisterInfoController {
    @Autowired
    RegisterInfoServiceImpl registerInfoServiceImpl;

    @ResponseBody
    @GetMapping("/registerInfo")
    public List<RegisterInfo> getAccountList() {
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
