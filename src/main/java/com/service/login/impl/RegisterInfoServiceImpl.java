package com.service.login.impl;

import com.dao.RegisterInfoMapper;
import com.dao.pojo.LoginDataDO;
import com.dao.pojo.RegisterInfo;
import com.service.login.RegistryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterInfoServiceImpl implements RegistryInfoService {
    @Autowired
    RegisterInfoMapper registerInfoMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
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
    public int loginVerify(LoginDataDO loginDataDO, HttpServletRequest req, HttpServletResponse resp) {
        RegisterInfo registerInfo = registerInfoMapper.getRegisterInfoList(loginDataDO);
        int state = 0;
        // 如果结果不等于null,则登录成功,写入rediscookie, 返回前端cookie
        // 1. 写入前端cookie
//        ValueOperations<String, String > valueOperations = stringRedisTemplate.opsForValue();
        if (registerInfo != null) {
            // 写入cookie
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", registerInfo.getUsername());
            httpSession.setAttribute("password", registerInfo.getPassword());
            state = 1;
        } else {
            logout(resp);
        }
        return state;
    }

    // 退出登录操作
    @Override
    public int logout(HttpServletResponse resp) {
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setPath("/");
        resp.addCookie(cookie);
        return 0;
    }



}