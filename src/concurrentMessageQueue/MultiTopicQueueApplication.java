package concurrentMessageQueue;

import concurrentMessageQueue.handler.MultiTopicMessageQueue;

public class MultiTopicQueueApplication {
    public static void main(String[] args) {
        MultiTopicMessageQueue<String> queue = new MultiTopicMessageQueue<>();

        queue.registerSubscriber("topic1", "subscriber1");
        queue.registerSubscriber("topic1", "subscriber2");

        Runnable publisher = () -> {
            for (int i = 0; i < 100; i++) {
                queue.publish("topic1", "Message" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable subscriber = () -> {
            for (int i = 0; i < 100; i++) {
                String message = queue.consume("topic1", "subscriber1");
                System.out.println(Thread.currentThread().getName() + " consumed: " + message);
            }
        };

        Runnable subscriber2 = () -> {
            for (int i = 0; i < 100; i++) {
                String message = queue.consume("topic1", "subscriber2");
                System.out.println(Thread.currentThread().getName() + " consumed: " + message);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread pubThread = new Thread(publisher, "Publisher");
        Thread subThread1 = new Thread(subscriber, "Subscriber1");
        Thread subThread2 = new Thread(subscriber2, "Subscriber2");

        pubThread.start();
        subThread1.start();
        subThread2.start();
    }
}
