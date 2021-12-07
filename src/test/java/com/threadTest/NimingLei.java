package com.threadTest;

public interface NimingLei {
    public static String a = "100";

    void test();
    void test2();
    default String test3() {
        return "这是一个方法";
    }
}
