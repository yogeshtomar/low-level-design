package messageQueue.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Message {
    private final String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
