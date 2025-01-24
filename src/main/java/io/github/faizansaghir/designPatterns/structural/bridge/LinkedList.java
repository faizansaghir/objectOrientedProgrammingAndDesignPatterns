package io.github.faizansaghir.designPatterns.structural.bridge;

import java.util.Arrays;

public class LinkedList<T> implements List<T> {
    private final java.util.List<T> list;
    public LinkedList(){
        list = new java.util.LinkedList<>();
    }
    @Override
    public void addToLast(T element) {
        list.add(element);
    }

    @Override
    public T removeFirst() {
        if(list.isEmpty())
            return null;
        return list.remove(list.size()-1);
    }
}
