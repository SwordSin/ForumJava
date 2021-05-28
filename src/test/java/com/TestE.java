package com;

import org.junit.Test;

public class TestE {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TestE testE1 = new TestE();
        TestE testE2 = testE1;
        TestE testE3 = new TestE();
        System.out.println(testE1.equals(testE1));
        System.out.println(testE1.equals(testE3));
        System.out.println(testE1.hashCode());
        System.out.println(testE2.hashCode());
        System.out.println(testE3.hashCode());
        TestE testE4 = (TestE) testE1.clone();
        System.out.println(testE4.hashCode());

    }
}
