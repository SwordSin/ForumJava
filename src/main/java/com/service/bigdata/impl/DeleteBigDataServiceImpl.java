package com.service.bigdata.impl;

import com.dao.bigdata.DeleteBigDataMapper;
import com.service.bigdata.DeleteBigDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeleteBigDataServiceImpl implements DeleteBigDataService {
    @Resource
    DeleteBigDataMapper deleteBigDataMapper;

    @Override
    public int deleteBigDataAll() {
        return deleteBigDataMapper.deleteBigDataAll();
    }
}
