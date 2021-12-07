package com.threadTest2;

import java.util.concurrent.atomic.AtomicInteger;

// 创建一个线程工厂
public class ThreadFactoryImpl  implements ThreadFactory{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private String threadName;

    public ThreadFactoryImpl(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(threadName+"-"+atomicInteger.getAndIncrement());
        return thread;
    }
}
