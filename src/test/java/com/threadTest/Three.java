package com.threadTest;

import java.util.concurrent.*;

public class Three implements Callable {
    @Override
    public Boolean call() throws Exception {
        System.out.println("这是一个callable接口");
        return true;
    }

    public static void main(String[] args) {
        Three three = new Three();
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Future<Boolean> future = executorService.submit(three);
        try {
            boolean a = future.get();
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
