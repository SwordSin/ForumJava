package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
//@SpringBootApplication
// 等同于
@SpringBootConfiguration // 表示配置类
@EnableAutoConfiguration //
@ComponentScan("com")
public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
    }
}
