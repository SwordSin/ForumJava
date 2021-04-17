package com.service;

import com.dao.RegisterInfoMapper;
import com.dao.pojo.RegisterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterInfoService {
    @Autowired
    RegisterInfoMapper registerInfoMapper;
    // 获取Account的内容
    public List<RegisterInfo> getAccoutList() {
        return registerInfoMapper.getRegisterInfoList();
    }
}
