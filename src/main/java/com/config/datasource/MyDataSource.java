package com.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyDataSource {
    @Bean(name = "bigDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.bigdata")
    public DataSource dataSourceBigData() {
//        return DataSourceBuilder.create().build();
        return new DruidDataSource();
    }
    //datasource
    @Bean(name = "forumDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.forum")
    public DataSource dataSourceForum() {
//        return DataSourceBuilder.create().build();
        return new DruidDataSource();
    }


}
