package concurrentMessageQueue.handler;

import concurrentMessageQueue.impl.FIFOQueue;
import concurrentMessageQueue.model.Message;
import concurrentMessageQueue.model.Subscriber;
import concurrentMessageQueue.publicInterface.IMessageQueue;
import concurrentMessageQueue.publicInterface.QueueStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MultiTopicMessageQueue <T> implements IMessageQueue<T> {
    private final Map<String, QueueStrategy<Message<T>>> topicQueues = new ConcurrentHashMap<>();
    private final Map<String, Map<String, Subscriber>> subscibers = new ConcurrentHashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void publish(String topic, T message) {
        lock.lock();
        try {
            QueueStrategy<Message<T>> queue = topicQueues.computeIfAbsent(
                    topic, t -> new FIFOQueue<>());
            int offset = queue.isEmpty() ? 0 : queue.dequeue().getOffset().get() + 1;
            queue.enqueue(new Message<>(topic, message, offset));
        } finally {
            lock.unlock();
        }
    }

    @Override
    public T consume(String topic, String subscriberId) {
        lock.lock();
        try {
            Subscriber subscriber = subscibers.get(topic).get(subscriberId);
            if (subscriber == null) {
                return null;
            }

            QueueStrategy<Message<T>> queue  = topicQueues.get(topic);
            if (queue == null || queue.isEmpty()) {
                return null;
            }

            Message<T> nextMessage = queue.dequeue();
            AtomicInteger offset = nextMessage.getOffset();
            offset.set(offset.get() + 1);
            return nextMessage.getContent();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void replay(String topic, String subscriberId) {
        lock.lock();
        try {
            Subscriber subscriber = subscibers.get(topic).get(subscriberId);
            if (subscriber != null) {
                subscriber.setOffset(0);
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void registerSubscriber(String topic, String subscriberId) {
        subscibers.computeIfAbsent(topic, t -> new ConcurrentHashMap<>())
                .putIfAbsent(subscriberId, new Subscriber(subscriberId, 0));
    }
}
