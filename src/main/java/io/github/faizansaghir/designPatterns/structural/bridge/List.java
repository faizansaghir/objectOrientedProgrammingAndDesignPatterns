package io.github.faizansaghir.designPatterns.structural.bridge;

public interface List<T> {
    void addToLast(T element);
    T removeFirst();
}
