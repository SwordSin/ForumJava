package com.dao.pojo.login;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;


@ApiModel("用户信息")
@Data
@TableName("register_info")
public class RegisterInfo {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    private String email;
    private String password;
    private String netName;
    private String username;
    private String headImg;
    private String param1;
    private String param2;
    private String param3;
    private String param4;
}
