package messageQueue.handler;

import lombok.SneakyThrows;
import messageQueue.model.Message;
import messageQueue.model.Topic;
import messageQueue.model.TopicSubscriber;

public class SubscriberWorker implements Runnable{
    private final Topic topic;
    private  final TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @SneakyThrows
    @Override
    public void run () {
        synchronized (topicSubscriber) {
            do {
                int curOffset = topicSubscriber.getOffset().get();
                while (curOffset >= topic.getMessages().size()) {
                    try {
                        topicSubscriber.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new RuntimeException("caught Interrupted exception");
                    }
                }
                Message message = topic.getMessages().get(curOffset);
                try {
                    topicSubscriber.getSubscriber().consume(message);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException("caught Interrupted exception while trying to subscribe the topic");
                }


                // We cannot just increment here since subscriber offset can be reset while it is consuming. So, after
                // consuming we need to increase only if it was previous one.
                topicSubscriber.getOffset().compareAndSet(curOffset, curOffset + 1);
            } while (true);
        }
    }

    synchronized public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
