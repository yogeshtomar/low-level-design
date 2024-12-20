package concurrentMessageQueue.impl;

import concurrentMessageQueue.publicInterface.QueueStrategy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityMessageQueue<T> implements QueueStrategy<T> {
    private final PriorityQueue<T> queue;
    public PriorityMessageQueue(Comparator<T> comparator) {
        this.queue = new PriorityQueue<>(comparator);
    }
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
