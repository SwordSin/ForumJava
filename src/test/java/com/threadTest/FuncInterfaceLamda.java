package com.threadTest;

public class FuncInterfaceLamda {
    public static void main(String[] args) {
        // lamda表达式
        FuncInterface funcInterface = () -> {
            System.out.println("这是要给lamda表达式");
        };
        // 匿名内部类

        FuncInterface funcInterface1 = new FuncInterface() {
            @Override
            public void lamdatest() {
                System.out.println("这是一个匿名内部类");
            }
        };
        funcInterface.lamdatest();
        funcInterface1.lamdatest();

        NimingLei nimingLei = new NimingLei() {
            private int a = 100;

            @Override
            public void test() {
                System.out.println("a");
            }

            @Override
            public void test2() {
                System.out.println("a");
            }
        };

        String a = nimingLei.test3();
        System.out.println(a);

    }
}
