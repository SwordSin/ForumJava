package com.dao.bigdata;

import com.dao.pojo.BigDataDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InsertBigDataMapper {
    int insertBigData(List<BigDataDO> bigDataDOS);
    // 通过批处理
    int insertBigData2(BigDataDO bigDataDOS);

}
