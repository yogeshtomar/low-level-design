package concurrentMessageQueue.model;


import lombok.AllArgsConstructor;


import java.util.concurrent.atomic.AtomicInteger;



public class Message<T> {
    private String topic;
    private T content = null;
    private AtomicInteger offset;

    public Message(String topic, T content, int value) {
        this.topic = topic;
        this.content = content;
        this.offset = new AtomicInteger(value);
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public T getContent() {
        return content;
    }

    public String getTopic() {
        return topic;
    }
}
