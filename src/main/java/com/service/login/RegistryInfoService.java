package com.service.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dao.pojo.login.LoginDataDO;
import com.dao.pojo.login.RegisterInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface RegistryInfoService {
    public List<RegisterInfo> getAccoutList();
    public int insertAccount(RegisterInfo registerInfo);
    public int loginVerify(LoginDataDO loingDataDO, HttpServletRequest httpServletRequest, HttpServletResponse resp);
    public int logout(HttpServletResponse resp);
    public RegisterInfo getAccountOne(String resultKey, String queryKey, Object quyeryValue);
    public RegisterInfo getAccountOne(QueryWrapper queryWrapper);
}
