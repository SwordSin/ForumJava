package com.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.ThreadPoolExecutor;

// 开启异步
@Configuration
@EnableAsync
public class AsyncConfig {
    @Bean(name = "scorePoolTaskExecutor")
    public ThreadPoolTaskExecutor getScorePoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        taskExecutor.setCorePoolSize(10);
        // 设置线程池维护线程的最大数量
        taskExecutor.setMaxPoolSize(100);
        // 缓存队列
        taskExecutor.setQueueCapacity(50);
        // 空闲时间, 当超过这个空闲时间, 会销毁核心线程之外的线程
        taskExecutor.setKeepAliveSeconds(200);
        // 异步方法的线程名称
        taskExecutor.setThreadNamePrefix("score-");

        /**
         * 线程已满后的拒绝策略
         */

        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }
}
