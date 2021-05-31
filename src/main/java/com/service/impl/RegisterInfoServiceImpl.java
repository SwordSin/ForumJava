package com.service.impl;

import com.dao.RegisterInfoMapper;
import com.dao.pojo.LoginDataDO;
import com.dao.pojo.RegisterInfo;
import com.service.RegistryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterInfoServiceImpl implements RegistryInfoService {
    @Autowired
    RegisterInfoMapper registerInfoMapper;
    // 获取Account的内容
    @Override
    public List<RegisterInfo> getAccoutList() {
        return registerInfoMapper.selectList(null);
//        return registerInfoMapper.getRegisterInfoList();
    }

    @Override
    public RegisterInfo getAccoutOne(String phone) {
        Map<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        return registerInfoMapper.selectByMap(map).get(0);
    }

    @Override
    public int insertAccount(RegisterInfo registerInfo) {
        int state;
        try {
            state = registerInfoMapper.insertRegisterInfo(registerInfo);
        }catch (Exception e) {
            if(e instanceof DuplicateKeyException){
                // 主键重复错误
                state = -1;
            }else {
                // 其他错误
                state = -2;
            }
        }
        return  state;
    }

    @Override
    public RegisterInfo loginVerify(LoginDataDO loginDataDO) {
        RegisterInfo registerInfo = registerInfoMapper.getRegisterInfoList(loginDataDO);
        // 如果结果不等于null,则登录成功,写入rediscookie, 返回前端cookie
        // 1. 写入前端cookie
        if (registerInfo != null) {
            // 写入cookie
        }
        return registerInfo;
    }

}
