package com.threadTest2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolOne {
    public static void main(String[] args) {
        final List<Integer> list = new ArrayList<>();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
