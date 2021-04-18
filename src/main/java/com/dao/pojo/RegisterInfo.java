package com.dao.pojo;

import lombok.Data;

@Data
public class RegisterInfo {
    private int userId;
    private Long phone;
    private String email;
    private String password;
    private String netName;
    private String username;
}
