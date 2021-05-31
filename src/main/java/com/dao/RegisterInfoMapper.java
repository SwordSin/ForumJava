package com.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dao.pojo.LoginDataDO;
import com.dao.pojo.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegisterInfoMapper extends BaseMapper<RegisterInfo> {
    public RegisterInfo getRegisterInfoList(LoginDataDO loginDataDO);
    public int insertRegisterInfo(RegisterInfo registerInfo);

}
