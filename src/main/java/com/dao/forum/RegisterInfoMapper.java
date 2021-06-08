package com.dao.forum;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dao.pojo.login.LoginDataDO;
import com.dao.pojo.login.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterInfoMapper extends BaseMapper<RegisterInfo> {
    public RegisterInfo getRegisterInfoList(LoginDataDO loginDataDO);
    public int insertRegisterInfo(RegisterInfo registerInfo);

}
