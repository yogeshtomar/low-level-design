package inMemoryCache.solid.evictionPolicyStrategies;

import inMemoryCache.solid.EvictionPolicy;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOEvictionPolicy <K> implements EvictionPolicy<K> {
    private final Queue<K> queue;

    public FIFOEvictionPolicy() {
        this.queue = new LinkedList<>();
    }

    @Override
    public void keyAccessed(K key) {
        queue.offer(key);
    }

    @Override
    public K evictKey() {
        return queue.poll();
    }
}
