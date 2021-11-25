package com.dao.pojo.login;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("register_info")
public class RegisterInfo {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    private String email;
    private String password;
    private String netName;
    private String username;
}
