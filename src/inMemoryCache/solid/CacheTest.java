package inMemoryCache.solid;

import inMemoryCache.solid.evictionPolicyStrategies.LRUEvictionPolicy;
import inMemoryCache.solid.impl.ThreadSafeCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheTest {
    public static void main(String[] args) {
        Cache<String , String > cache = new ThreadSafeCache<>(5, new LRUEvictionPolicy<>());

        // Define a task for putting elements into the cache
        Runnable putTask = () -> {
            for (int i = 0; i < 5; i++) {
                String key = "Key" + i;
                String value = "Value" + i;
                cache.put(key, value);
                Thread.currentThread().setName("Thread" + i);
                System.out.println(Thread.currentThread().getName() + " put: " + key + " -> " + value);
                try {
                    Thread.sleep(100); // Simulate some delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Define a task for retrieving elements from the cache
        Runnable getTask = () -> {
            for (int i = 0; i < 5; i++) {
                String key = "Key" + i;
                String value = cache.get(key);
                System.out.println(Thread.currentThread().getName() + " get: " + key + " -> " + (value != null ? value : "null"));
                try {
                    Thread.sleep(150); // Simulate some delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Create a thread pool to execute tasks concurrently
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit tasks to the executor
        executorService.submit(putTask); // Thread 1 putting unique values
        executorService.submit(putTask); // Thread 2 putting unique values
        executorService.submit(getTask); // Thread 3 reading from the cache

        // Shut down the executor
        executorService.shutdown();
    }
}
