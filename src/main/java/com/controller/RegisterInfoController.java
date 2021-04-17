package com.controller;

import com.dao.pojo.RegisterInfo;
import com.service.RegisterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegisterInfoController {
    @Autowired
    RegisterInfoService registerInfoService;

    @ResponseBody
    @GetMapping("/registerInfo")
    public List<RegisterInfo> getAccountList() {
        return registerInfoService.getAccoutList();
    }
}
