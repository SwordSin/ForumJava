package com.threadTest;

public class TestYield {
    public static void main(String[] args) {
        MyYiel myYiel = new MyYiel();
        new Thread(myYiel).start();
        new Thread(myYiel).start();
        new Thread(myYiel).start();
        new Thread(myYiel).start();
        new Thread(myYiel).start();
    }

}

// 线程类
class  MyYiel implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始");
        Thread.yield();
        System.out.println("获取线程状态");
        // 线程重新调度
        System.out.println(Thread.currentThread().getName() + "线程结束");
    }
}

