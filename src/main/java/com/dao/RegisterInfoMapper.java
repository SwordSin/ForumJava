package com.dao;

import com.dao.pojo.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegisterInfoMapper {
    public List<RegisterInfo> getRegisterInfoList();
    public RegisterInfo getRegisterInfoList(String phone);
    public int insertRegisterInfo(RegisterInfo registerInfo);
}
