package io.github.faizansaghir.designPatterns.structural.bridge;

public class BridgePatternMain {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Queue<Integer> queue = new Queue<>(linkedList);
        queue.offer(15);
        queue.offer(10);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
