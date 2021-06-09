package com.dao.bigdata;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dao.pojo.bigdata.BigDataDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteBigDataMapper extends BaseMapper<BigDataDO> {
    int deleteBigDataAll();
}
