package com.threadTest;

public class SynchronizedTest {
    public static void main(String[] args) {
        TestSync testSync = new TestSync();
        new Thread(testSync).start();
        new Thread(testSync).start();
        new Thread(testSync).start();

    }
}

class TestSync implements Runnable {

    private int tickNum = 10;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickNum > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "减少票数" + tickNum--);
                } else {
                    break;
                }
            }
        }
    }
}
