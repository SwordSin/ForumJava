package com.service.bigdata.impl;

import com.dao.bigdata.GetBigDataMapper;
import com.dao.pojo.bigdata.BigDataDO;
import com.service.bigdata.GetBigDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetBigDataServiceImpl implements GetBigDataService {
    @Autowired
    GetBigDataMapper getBigDataMapper;

    @Override
    public List<BigDataDO> getBigDataAll() {
//        List<BigDataDO> list = new ArrayList<>();
//        BigDataDO bigDataDO = getBigDataMapper.selectById(26);
//        list.add(bigDataDO);
//        return list;
        return getBigDataMapper.getAllBigData();
    }
}
