package com.threadTest;


// 通过继承thread类来实现多线程
public class One extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是一个多线程");
    }

    public static void main(String[] args) {
        One one = new One();
        one.start();
        One one2 = new One();
        one2.start();
        One one3 = new One();
        one3.start();
    }

}
