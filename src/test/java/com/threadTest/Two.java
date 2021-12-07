package com.threadTest;

public class Two implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("实现runable方法来启动线程");
    }

    public static void main(String[] args) {
        Two two = new Two();
        Thread thread = new Thread(two);
        thread.start();
        Thread thread2 = new Thread(two);
        thread2.start();
        Thread thread3 = new Thread(two);
        thread3.start();
    }
}
