package com.service.bigdata;

import java.util.List;
import java.util.Map;

// 插入千万级别数据
public interface InsertBigDataService {
    // 插入数据
    void insetBigData(List<Map<String, Object>> list);

    // 通过批处理的方式添加
    // 应用mybatis SqlSessionFactory 对象的方式手动提交事务
    Long insetBigData2(int size);

    // 注解方式开启手动提交事务
    // 使用spring boot提供的api手动提交事务
    void insetBigDataSpringboot();


}
