package concurrentMessageQueue.publicInterface;

public interface IMessageQueue<T> {
    void publish(String topic, T message);
    T consume(String topic, String subscriberId);
    void replay(String topic, String subscriberId);
    void registerSubscriber(String topic, String subscriberId);
}
