package concurrentMessageQueue.impl;

import concurrentMessageQueue.publicInterface.QueueStrategy;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOQueue<T> implements QueueStrategy<T> {
    private final Queue<T> queue = new LinkedList<>();
    @Override
    public synchronized void enqueue(T message) {
        queue.add(message);
    }

    @Override
    public synchronized T dequeue() {
        return queue.poll();
    }

    @Override
    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
