package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
// 数据源配置类
//import com.config.datasource.MyDataSource;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
// 等同于
//@SpringBootConfiguration // 表示配置类
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class }) //
//@ComponentScan("com")
public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
    }
}
