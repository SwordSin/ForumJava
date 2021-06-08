package com.dao.bigdata;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dao.pojo.bigdata.BigDataDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetBigDataMapper extends BaseMapper<BigDataDO> {
    List<BigDataDO> getAllBigData();
}
