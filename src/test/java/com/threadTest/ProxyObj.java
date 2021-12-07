package com.threadTest;

// 代理对象
public class ProxyObj {
    private MyMarry marry;

    ProxyObj(MyMarry marry) {
        this.marry = marry;
    }
    public void proxy() {
        System.out.println("结婚前住准备");
        marry.marry();
        System.out.println("结婚后首位");
    }

    public static void main(String[] args) {
        MyMarry marry = new MyMarry();
        ProxyObj proxyObj = new ProxyObj(marry);
        proxyObj.proxy();
    }
}

class MyMarry {
    public void marry() {
        System.out.println("我结婚");
    }
}
