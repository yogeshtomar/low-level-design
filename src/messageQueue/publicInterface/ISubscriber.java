package messageQueue.publicInterface;

import messageQueue.model.Message;

public interface ISubscriber {
    String getId();
    void consume(Message message) throws InterruptedException;
}
