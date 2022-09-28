package com.jeonghyeon.javastudy.effectivejava.item1;

public class ChildClass implements Parent {
    private String str = "자식";
    @Override
    public void methodA() {
        System.out.println("자식A");
    }

    @Override
    public String toString() {
        return "ChildClass{" +
                "str='" + str + '\'' +
                '}';
    }
}
