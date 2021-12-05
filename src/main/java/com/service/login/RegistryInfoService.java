package com.service.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.ResultWapper;
import com.dao.pojo.login.LoginDataDO;
import com.dao.pojo.login.LoginLogDO;
import com.dao.pojo.login.RegisterInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface RegistryInfoService {
    public List<RegisterInfo> getAccoutList();
    public ResultWapper<String> insertAccount(RegisterInfo registerInfo);
    public ResultWapper<RegisterInfo> loginVerify(LoginDataDO loingDataDO, HttpServletRequest httpServletRequest, HttpServletResponse resp);
    public int logout(HttpServletResponse resp);
    public Object getAccountOne(String resultKey, String queryKey, Object quyeryValue);
    public RegisterInfo getAccountOne(QueryWrapper queryWrapper);

    public Integer saveLoginLog(String username, Boolean rememberMe, HttpServletRequest req);
    public ResultWapper<LoginLogDO> getLoginLog(Long id);
}
