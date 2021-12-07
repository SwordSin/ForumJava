package com.threadTest2;

public interface ThreadFactory {
    Thread newThread(Runnable runnable);
}
