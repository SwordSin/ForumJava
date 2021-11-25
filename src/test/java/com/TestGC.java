package com;

public class TestGC {
    private static final int _1MB = 1024 * 1024;

    /**
     * -Xms30M
     * -Xmx30M
     * -XX:+PrintGCDetails  打印gc的详细日志
     * -XX:+PrintHeapAtGC  打印出触发gc之前之后的日志
     */
    // java -classpath "." -Xms30M -Xmx30M -XX:+PrintGCDetails -XX:+PrintHeapAtGC com.TestGC
    public static void main(String[] args) {
        byte[] allocation, allocation2, allocation3, allocation4;
        allocation = new byte[2*_1MB];
        System.out.println("创建2M后");
        allocation2 = new byte[2*_1MB];
        System.out.println("创建2M后");
        allocation3 = new byte[2*_1MB];
        System.out.println("创建2M后");
//        allocation4 = new byte[2*_1MB];
//        System.out.println("创建2M后");

        // 比较两个字符串
        String a = "abc";
        String b = "abc";
        // a 和 b 两个符号引用都指向字符串常量池中的同一个常量
        System.out.println(a == b);
    }
}
