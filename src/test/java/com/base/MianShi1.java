package com.base;

public class MianShi1 {

    public final int a;
    MianShi1(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Object o = new Object();
        float f = 3.4234f;
        int a = 10;
        System.out.println(f * a);

        short s1 = 1;
//        s1 = s1 + 1;

        MianShi1 mianShi1 = new MianShi1(10);
        System.out.println(mianShi1.a);
    }
}
