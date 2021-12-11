package com.service.login.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.GetHashImg;
import com.common.RedisCommon;
import com.common.ResultWapper;
import com.dao.forum.LoginLogMapper;
import com.dao.forum.RegisterInfoMapper;
import com.dao.pojo.login.LoginDataDO;
import com.dao.pojo.login.LoginLogDO;
import com.dao.pojo.login.RegisterInfo;
import com.service.AsyncServiceMethods;
import com.service.login.RegistryInfoService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterInfoServiceImpl implements RegistryInfoService {
    @Autowired
    private RegisterInfoMapper registerInfoMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private LoginLogMapper loginLogMapper;
    @Resource
    private RedisCommon<LoginLogDO> redisCommonLoginDataDo;
    @Autowired
    private AsyncServiceMethods asyncServiceMethods;

    // 获取Account的内容
    @Override
    public List<RegisterInfo> getAccoutList() {
        return registerInfoMapper.selectList(null);
//        return registerInfoMapper.getRegisterInfoList();
    }

    @Override
    public ResultWapper<String> insertAccount(RegisterInfo registerInfo) {
        ResultWapper<String> resultWapper = null;
        try {
            // 给registerInfo设置头像
            String hashImg = GetHashImg.createBase64Avatar(Math.abs(registerInfo.getNetName().hashCode()));
            registerInfo.setHeadImg(GetHashImg.BASE64_PREFIX + hashImg);
            // 将数据插入到数据库
            registerInfoMapper.insertRegisterInfo(registerInfo);
            // 获取userId
            int userId = registerInfo.getUserId();
            resultWapper = ResultWapper.getResult(1, Integer.toString(userId));
        }catch (Exception e) {
            if(e instanceof DuplicateKeyException){
                // 主键重复错误
                ResultWapper.getResult(-1, "主键重复错误");
            }else {
                // 其他错误
                ResultWapper.getResult(1, "注册发生未知错误");
            }
        }
        return  resultWapper;
    }

    @Override
    public ResultWapper<RegisterInfo> loginVerify(LoginDataDO loginDataDO, HttpServletRequest req, HttpServletResponse resp) {

        ResultWapper<RegisterInfo> result = null;
//        RegisterInfo registerInfo = registerInfoMapper.getRegisterInfoList(loginDataDO);
        // mybatis plus
        QueryWrapper<RegisterInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .select("*")
                .eq("username", loginDataDO.getUsername())
                .eq("password", loginDataDO.getPassword());
        RegisterInfo registerInfo = registerInfoMapper.selectOne(queryWrapper);
        // 如果结果不等于null,则登录成功,写入rediscookie, 返回前端cookie
        // 1. 写入前端cookie
//        ValueOperations<String, String > valueOperations = stringRedisTemplate.opsForValue();
        if (registerInfo != null) {
            // 写入cookie
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", registerInfo.getUsername());
            httpSession.setAttribute("password", registerInfo.getPassword());
            // 查看是否是记住密码 记住密码,cookie保存30天, 不记住密码cookie保存2小时
            int time = 3600 * 2;
            if (loginDataDO.getRememberMe() == true) {
                time = 3600 * 24 * 30;
            }
            Cookie userPw = new Cookie("username" + loginDataDO.getUsername(), loginDataDO.getPassword());
            userPw.setPath("/");
            userPw.setMaxAge(time);
            resp.addCookie(userPw);
            result = ResultWapper.getResult(1, registerInfo);
            // 保存log日志再mysql和redis
            asyncServiceMethods.saveLoginLog(loginDataDO.getUsername(), loginDataDO.getRememberMe(), req);
            // 将sessionid 保存在redis
            asyncServiceMethods.saveSessionInRedis(req.getSession().getId(), registerInfo);
        } else {
            result = ResultWapper.getResult(0, null);
            logout(resp);
        }
        return result;
    }

    // 获取单个记录
    @Override
    public Object getAccountOne(String resultKey, String queryKey, Object queryValue) {
//        registerInfoMapper.selectOne()
//        return registerInfoMapper.selectByMap(map).get(0);
        // 创建wapper对象
        QueryWrapper<RegisterInfo> queryWrapper = new QueryWrapper<>();
        // 构造查询条件
        queryWrapper.select(resultKey)
                    .eq(queryKey, queryValue).last("LIMIT 1");
        RegisterInfo registerInfo = registerInfoMapper.selectOne(queryWrapper);
        // 把该对象转化成map
        Map<String , Object> registerInfoMap = JSON.parseObject(JSON.toJSONString(registerInfo), new TypeReference<Map<String,Object>>(){});
        return registerInfoMap.get(resultKey);

    }


    @Override
    public RegisterInfo getAccountOne(QueryWrapper queryWrapper) {
        return null;
    }

    // 保存登录日志
//    @Override
//    @Async
//    public Integer saveLoginLog(String username, Boolean rememberMe, HttpServletRequest req) {
//        LoginLogDO loginLogDO = new LoginLogDO();
//        loginLogDO.setUsername(username);
//        loginLogDO.setRememberMe(rememberMe);
//        loginLogDO.setIp(req.getRemoteAddr());
//        loginLogDO.setLoginDate(new Date());
//        Integer saveStatus = loginLogMapper.insert(loginLogDO);
//        // 判断是否保存成功
//        if (saveStatus == 0) return 0;
//        Long id = loginLogDO.getId();
//        saveStatus = redisCommonLoginDataDo.saveRedis("loginlog:" + id, loginLogDO);
//        return saveStatus;
//    }

    // 获取登录日志
    @Override
    public ResultWapper<LoginLogDO> getLoginLog(Long id) {
        LoginLogDO loginLogDO = redisCommonLoginDataDo.getRedis("loginlog:" + id, LoginLogDO.class);
        if (loginLogDO == null) {
            loginLogDO = loginLogMapper.selectById(id);
        }
        if (loginLogDO == null) return ResultWapper.getResult(0, loginLogDO);
        return ResultWapper.getResult(1, loginLogDO);
    }

    // 退出登录操作
    @Override
    public int logout(HttpServletResponse resp) {
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setPath("/");
        // 设置cookie过期时间
        cookie.setMaxAge(3600 * 2); // 设置cookie过期时间为2个小时
        resp.addCookie(cookie);
        return 0;
    }

}
