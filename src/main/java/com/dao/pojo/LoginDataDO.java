package com.dao.pojo;

import lombok.Data;

@Data
public class LoginDataDO {
    private String username;
    private String password;
    private Boolean savePassword;
}
