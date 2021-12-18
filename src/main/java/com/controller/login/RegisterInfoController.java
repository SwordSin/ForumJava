package com.controller.login;

import com.common.ResultWapper;
import com.config.LogPrint;
import com.dao.pojo.login.LoginDataDO;
import com.dao.pojo.login.LoginLogDO;
import com.dao.pojo.login.RegisterInfo;
import com.service.login.impl.RegisterInfoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/userInfo")
//说明接口文件
@Api(value = "登录接口测试", tags = "用户接口")
public class RegisterInfoController {
    @Autowired
    RegisterInfoServiceImpl registerInfoServiceImpl;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    // 获取redis中的数据
    @LogPrint
    @ResponseBody
    @GetMapping("/getUserInfoList")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "获取用户列表")
    public List<RegisterInfo> getAccountList() {
        return registerInfoServiceImpl.getAccoutList();
    }

    // 注册用户
    @ApiOperation(value = "注册用户")
    @LogPrint
    @ResponseBody
    @PostMapping("/registerInfo")
    public ResultWapper<String> saveAccountList(@RequestBody RegisterInfo registerInfo, HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) {
        return registerInfoServiceImpl.insertAccount(registerInfo);
    }

    // 登录
    @ApiOperation(value = "用户登录")
    @LogPrint
    @ResponseBody
    @PostMapping("/login")
    public ResultWapper<RegisterInfo> login(@RequestBody LoginDataDO loingDataDO, HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) {
        // int state
        return registerInfoServiceImpl.loginVerify(loingDataDO, httpRequest, httpServletResponse);
    }

    // 根据不同的条件获取单个用户
    @LogPrint
    @ResponseBody
    @GetMapping("/getOneAccountKey")
    @ApiOperation(value = "获取单个用户信息")
    public String getOneAccountKey(String queryKey, String queryValue, String resultKey) {
        return registerInfoServiceImpl.getAccountOne(resultKey, queryKey, queryValue).toString();
    }

    // 获取登录日志
    @ApiOperation(value = "获取登录日志")
    @ResponseBody
    @GetMapping("/getLoginLogOne")
    public ResultWapper<LoginLogDO> getLoginLogOne(Long id) {
        // int state
        return registerInfoServiceImpl.getLoginLog(id);
    }

}
