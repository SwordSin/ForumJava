package com.dao.pojo.login;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("登录信息")
@Data
public class LoginDataDO {
    private String username;
    private String password;
    private Boolean rememberMe;
}
