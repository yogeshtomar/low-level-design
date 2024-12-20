package concurrentMessageQueue.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Subscriber {
    private final String id;
    private AtomicInteger offset;

    public Subscriber(String id, int value) {
        this.id = id;
        this.offset = new AtomicInteger(value);
    }

    public void setOffset(int value) {
        offset.set(value);
    }

}
