package com.controller.redisTest;

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

}
