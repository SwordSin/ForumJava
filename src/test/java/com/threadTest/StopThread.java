package com.threadTest;

public class StopThread implements Runnable{

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "线程运行次数:" + i++);
        }
    }

    public void stop() {
        flag = false;
    }

    public static void main(String[] args) {
        // 执行线程
        StopThread thread = new StopThread();
        new Thread(thread).start();
        new Thread(thread).start();
        // 执行主线程
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程次数" + i);
            if (i == 900) {
                thread.stop();
                System.out.println("线程停止了");
            }
        }
    }
}
