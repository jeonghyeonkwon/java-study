package com.jeonghyeon.javastudy.effectivejava.item1;

public interface ChildInter {
    static Parent child(){
        return new ChildClass();
    }
}
