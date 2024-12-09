package inMemoryCache.usingLocks;

public class CacheTest {
    public static void main(String[] args) {
        InMemoryCache<String, String> cache = new InMemoryCache<>();

        Runnable writer = () -> {
            for (int i = 0; i < 10; i++) {
                String key = "key" + i;
                String value = "value" + i;

                cache.put(key, value);
                System.out.println(Thread.currentThread().getName() + " put: " + key + " -> " + value);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable reader = () -> {
            for (int i = 0; i < 10; i++) {
                String key = "key" + i;
                String value = cache.get(key);
                System.out.println(Thread.currentThread().getName() + " get: " + key + " -> " + value);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread writerThread1 = new Thread(writer, "Writer-1");
        Thread writerThread2 = new Thread(writer, "Writer-2");
        Thread readerThread1 = new Thread(reader, "Reader-1");
        Thread readerThread2 = new Thread(reader, "Reader-2");

        writerThread1.start();
        writerThread2.start();
        readerThread1.start();
        readerThread2.start();

        try {
            writerThread1.join();
            writerThread2.join();
            readerThread1.join();
            readerThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final cache size: " + cache.size());
    }
}
