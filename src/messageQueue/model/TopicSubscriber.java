package messageQueue.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import messageQueue.publicInterface.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;


@AllArgsConstructor
public class TopicSubscriber {
    private final AtomicInteger offset;
    private final ISubscriber subscriber;

    public TopicSubscriber(@NonNull final ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }

    public AtomicInteger getOffset() {
        return offset;
    }
}
