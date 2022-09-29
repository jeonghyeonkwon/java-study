package com.jeonghyeon.javastudy.effectivejava.item3;

public class SingletonFactory {
    private static final SingletonFactory INSTANCE = new SingletonFactory();
    private SingletonFactory(){}
    public static SingletonFactory getInstance(){
        return INSTANCE;
    }
}
