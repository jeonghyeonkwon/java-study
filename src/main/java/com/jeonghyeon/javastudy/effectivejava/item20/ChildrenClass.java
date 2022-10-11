package com.jeonghyeon.javastudy.effectivejava.item20;

public class ChildrenClass extends ParentAbstractClass{
    @Override
    void test1() {
        System.out.println("재정의 test1");
    }
    void test2(){
        System.out.println("test2");
    }
}
