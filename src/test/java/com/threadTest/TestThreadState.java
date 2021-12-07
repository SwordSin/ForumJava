package com.threadTest;

public class TestThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.State state = null;
        System.out.println("线程启动前的状态");
        System.out.println(thread.getState());
        thread.start();

        System.out.println(thread.getState());
        state = thread.getState();
        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(1000);
                state = thread.getState();
                System.out.println(state);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
