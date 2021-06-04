package com.service.login;

import com.dao.pojo.LoginDataDO;
import com.dao.pojo.RegisterInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface RegistryInfoService {
    public List<RegisterInfo> getAccoutList();
    public RegisterInfo getAccoutOne(String phone);
    public int insertAccount(RegisterInfo registerInfo);
    public int loginVerify(LoginDataDO loingDataDO, HttpServletRequest httpServletRequest, HttpServletResponse resp);
    public int logout(HttpServletResponse resp);
}
