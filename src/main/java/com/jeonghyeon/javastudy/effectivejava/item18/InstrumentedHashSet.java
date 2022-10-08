package com.jeonghyeon.javastudy.effectivejava.item18;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {
    // 추가된 원소의 수
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        System.out.println("add() -> " + addCount);
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        System.out.println("addAll() -> " + addCount);
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
