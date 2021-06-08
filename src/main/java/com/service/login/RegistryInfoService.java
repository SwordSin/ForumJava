package com.service.login;

import com.dao.pojo.login.LoginDataDO;
import com.dao.pojo.login.RegisterInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface RegistryInfoService {
    public List<RegisterInfo> getAccoutList();
    public RegisterInfo getAccoutOne(String phone);
    public int insertAccount(RegisterInfo registerInfo);
    public int loginVerify(LoginDataDO loingDataDO, HttpServletRequest httpServletRequest, HttpServletResponse resp);
    public int logout(HttpServletResponse resp);
}
