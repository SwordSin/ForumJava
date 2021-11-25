package com.dao.pojo.login;

import lombok.Data;

@Data
public class LoginDataDO {
    private String username;
    private String password;
    private Boolean rememberMe;
}
