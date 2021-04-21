package com.service.impl;

import com.dao.RegisterInfoMapper;
import com.dao.pojo.RegisterInfo;
import com.service.RegistryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterInfoServiceImpl implements RegistryInfoService {
    @Autowired
    RegisterInfoMapper registerInfoMapper;
    // 获取Account的内容
    @Override
    public List<RegisterInfo> getAccoutList() {
        return registerInfoMapper.getRegisterInfoList();
    }

    public RegisterInfo getAccout(String phone) {
        return registerInfoMapper.getRegisterInfoList(phone);
    }

    @Override
    public int insertAccount(RegisterInfo registerInfo) {
        return registerInfoMapper.insertRegisterInfo(registerInfo);
    }

}
