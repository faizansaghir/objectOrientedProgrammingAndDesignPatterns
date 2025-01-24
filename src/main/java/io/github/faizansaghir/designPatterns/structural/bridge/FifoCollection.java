package io.github.faizansaghir.designPatterns.structural.bridge;

public interface FifoCollection<T> {
    void offer(T element);
    T poll();
}
