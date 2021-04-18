package com.service;

import com.dao.pojo.RegisterInfo;

import java.util.List;

public interface RegistryInfoService {
    public List<RegisterInfo> getAccoutList();
    public int insertAccount(RegisterInfo registerInfo);
}
