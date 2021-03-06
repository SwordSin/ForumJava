package com.dao.bigdata;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dao.pojo.bigdata.BigDataDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsertBigDataMapper extends BaseMapper<BigDataDO> {
    int insertBigData(List<BigDataDO> bigDataDOS);
    // 通过批处理
    int insertBigData2(BigDataDO bigDataDOS);
}
