package com.controller.redisTest;

import com.common.BusinessException;
import com.common.Result;
import com.common.ResultCode;
import com.service.redisTest.impl.UseRedisServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api(value = "测试redis", tags = "redis测试接口")
@Controller
@RequestMapping("/useRedis")
public class UseRedisController {


    @Resource
    private UseRedisServiceImpl UseRedisServiceImpl;

    // 想redis中存储数据
    @ApiOperation("存储一个用户数据")
    @GetMapping("/saveRedis")
    @ResponseBody
    public String saveRedis(String name, String user, String password) {
        return UseRedisServiceImpl.saveUser(name, user, password);
    }

    // 凡是一个同意接口返回值
    @ApiOperation("测试一个同意标准返回接口")
    @GetMapping("/testUnformInterface")
    @ResponseBody
    public Integer testUnformInterface() {
        return 1100;
    }

    @ApiOperation("测试一个同意标准返回接口2")
    @GetMapping("/testUnformInterface2")
    @ResponseBody
    public String  testUnformInterface2() {
        return "这hi一个成功的消息";
    }

    @ApiOperation("测试系统异常")
    @GetMapping("/error01")
    @ResponseBody
    public void errorTest() {
        int i = 9/0;
    }

    @ApiOperation("测试业务异常")
    @GetMapping("/error02")
    @ResponseBody
    public void errorWorkTest() {
        throw new BusinessException(ResultCode.PARAM_IS_INVALID);
    }

}
