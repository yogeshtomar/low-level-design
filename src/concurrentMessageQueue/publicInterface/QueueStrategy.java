package concurrentMessageQueue.publicInterface;

public interface QueueStrategy<T> {
    void enqueue(T message);
    T dequeue();
    boolean isEmpty();
}
