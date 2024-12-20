package concurrentMessageQueue.publicInterface;

import concurrentMessageQueue.model.Message;

public interface ISubscriber {
    String getId();
    void consume(Message message);
}
