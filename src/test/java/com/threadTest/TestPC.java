package com.threadTest;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.ibatis.cache.decorators.ScheduledCache;

// 生产者, 消费者测试: 管程法
public class TestPC {
    public static void main(String[] args) {
        // 创建缓冲区
        CacheRegion cacheRegion = new CacheRegion();
        // 生产者
        Productor productor = new Productor(cacheRegion);
        // 消费这
        Customer customer = new Customer(cacheRegion);

        // 生产者线程
        new Thread(productor).start();
        // 消费者线程
        new Thread(customer).start();

    }
}

// 生产者
class Productor implements Runnable {

    private CacheRegion cacheRegion;
    Productor(CacheRegion cacheRegion) {
        this.cacheRegion = cacheRegion;
    }

    @Override
    public void run() {
        // 生产
        for (int i = 0; i < 10; i++) {
            Chicken chicken = cacheRegion.addChicken();
            if (chicken != null) {
                System.out.println("生产的鸡" + chicken.getNum());
            }
        }
    }
}

// 消费者
class Customer implements Runnable {

    private CacheRegion cacheRegion;
    Customer(CacheRegion cacheRegion) {
        this.cacheRegion = cacheRegion;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Chicken chicken = cacheRegion.shifChicken();
            if ( chicken != null) {
                System.out.println("消费鸡"+chicken.getNum());
            }
        }
    }
}


// 产品
class Chicken {
    private int num;
    public Chicken(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}

// 缓冲区
class CacheRegion {
    private Chicken[] chickens = new Chicken[10];

    // 容器计数器
    int count = 0;

    // 生产者生产
    public synchronized Chicken addChicken () {
        Chicken chicken = null;
        if (count == chickens.length - 1) {
            System.out.println("缓冲区满");
            // 生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chicken = new Chicken(count);
        chickens[count] = chicken;
        count++;
        // 通知消费者可以消费
        this.notifyAll();
        return chicken;
    }

    // 消费者消费
    public synchronized Chicken shifChicken() {
        Chicken chicken = null;
        if (count==0) {
            System.out.println("缓冲区空");
            try {
                // 消费这等待消费
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chicken = chickens[count];
        count--;
        // 通知生产者生产
        this.notifyAll();
        return chicken;
    }
}