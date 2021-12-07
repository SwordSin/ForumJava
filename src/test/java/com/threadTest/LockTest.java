package com.threadTest;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        Object o = new Object();
        TestLock testLock = new TestLock();
        new Thread(testLock).start();
        new Thread(testLock).start();
        new Thread(testLock).start();
    }

}

class TestLock implements  Runnable{
    int tickNum = 1000;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
                try {
                    lock.lock();
                    if (tickNum > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "消费一个"+tickNum--);
                    } else {
                        break;
                    }
                } finally {
                    lock.unlock();
                }

        }
    }
}
