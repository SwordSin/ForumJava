package com.service;

import com.dao.pojo.LoginDataDO;
import com.dao.pojo.RegisterInfo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface RegistryInfoService {
    public List<RegisterInfo> getAccoutList();
    public RegisterInfo getAccoutOne(String phone);
    public int insertAccount(RegisterInfo registerInfo);
    public RegisterInfo loginVerify(LoginDataDO loingDataDO);
}
