package com.dao.pojo.login;

import lombok.Data;

import java.util.Map;

@Data
public class UserIpDetailedDO {
    private String address;
    private Map<String, Object> content;
    private String status;
}
