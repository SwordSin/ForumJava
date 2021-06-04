package com.service.bigdata;

import com.dao.InsertBigDataMapper;
import com.dao.pojo.BigDataDO;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class InsertBigDataServiceImpl implements InsertBigDataService {

    @Autowired
    InsertBigDataMapper insertBigDataMapper;
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    TransactionDefinition transactionDefinition;

    @Override
    public void insetBigData(List<Map<String, Object>> list) {
        List<BigDataDO> list1 = new ArrayList<>();
        list1.add(new BigDataDO());
        list1.add(new BigDataDO());
        list1.add(new BigDataDO());
        int result = insertBigDataMapper.insertBigData(list1);
        System.out.println("插入结果" + result);
    }

    // 手动提交事务
    @Override
    public Long insetBigData2(int size) {
        // 开启手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        InsertBigDataMapper getInsertMapper = sqlSession.getMapper(InsertBigDataMapper.class);
        // 获取代码块执行时间
        long a = new Date().getTime();
        long status = 0;
        try {
            // 执行两次插入100条调数据
            createBigDataList(size/2).stream().forEach(value -> {
                getInsertMapper.insertBigData2(value);
            });
            // 提交事务
            sqlSession.commit();
            createBigDataList(size - size/2).stream().forEach(value -> {
                getInsertMapper.insertBigData2(value);
            });
            // 提交事务
            sqlSession.commit();
            // 清除资源
            sqlSession.flushStatements();
            status = new Date().getTime() - a;
        } catch (Exception e) {
            // 如果出现错误回滚sql
            sqlSession.rollback();
            // 清除资源
            sqlSession.flushStatements();
            e.printStackTrace();
        }
        return status;
    }

    //手动提交事务 - 事务
    @Override
    public void insetBigDataSpringboot() {
        // 获取事务管理对象
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            // 插入数据
            insertBigDataMapper.insertBigData2(new BigDataDO());
            insertBigDataMapper.insertBigData2(new BigDataDO());
            // 手动提交
            dataSourceTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            // 回滚事务
            dataSourceTransactionManager.rollback(transactionStatus);
        }
    }

    public static List<BigDataDO> createBigDataList(int size) {
        List<BigDataDO> list = new ArrayList<>();
        for (int i = 0;i < size;i++) {
            BigDataDO bigDataDO = new BigDataDO();
            bigDataDO.setTest1("a");
            bigDataDO.setTest2("a");
            bigDataDO.setTest3("a");
            bigDataDO.setTest4("a");
            bigDataDO.setTest5("a");
            bigDataDO.setTest6( (int) Math.floor(Math.random() * 100));
            list.add(bigDataDO);
        }
        return list;
    }


    public static void main(String[] args) throws InterruptedException {
        // 获取一个随机数
        System.out.println(Math.floor(Math.random() * 100));
        System.out.println(Math.ceil(12.3));
        long a = new Date().getTime();
        Thread.sleep(1000);
        long b = new Date().getTime();
        System.out.println(b - a);
    }

}
