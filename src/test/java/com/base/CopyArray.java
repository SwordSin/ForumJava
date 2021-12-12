package com.base;

import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        // 拷贝一个数组
        // 1. clone
        int[] a = new int[10];
        a[0] = 11;
        int[] b = a.clone();

        System.out.println(a == b);

        int[] c = Arrays.copyOf(a, a.length + 20);
        System.out.println(Arrays.toString(c));
    }
}
