package io.github.faizansaghir.designPatterns.structural.bridge;

public class Queue<T> implements FifoCollection<T> {
    private final List<T> list;
    public Queue(List<T> list) {
        this.list = list;
    }

    @Override
    public void offer(T element) {
        list.addToLast(element);
    }

    @Override
    public T poll() {
        return list.removeFirst();
    }
}
