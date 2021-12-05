package com.dao.pojo.login;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 登录日志信息
@ApiModel("登录日志信息")
@Data
@TableName("login_log")
public class LoginLogDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String username;
    private Boolean rememberMe;
    private String ip;
    // 登录时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date loginDate;
    // 退出时间
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date logoutDate;
}
