package inMemoryCache.ConcurrentHashMap.evictionStrategy.impl;

import inMemoryCache.ConcurrentHashMap.evictionStrategy.EvictionStrategy;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class FirstInFirstOutEvictionStrategy <K> implements EvictionStrategy <K> {
    private final Queue<K> queue;

    public FirstInFirstOutEvictionStrategy() {
        this.queue = new LinkedList<>();
    }

    @Override
    public void keyAccessed(K key) {
        if (!queue.contains(key)) {
            queue.add(key);
        }
    }

    @Override
    public Optional<K> evictKey() {
        return Optional.ofNullable(queue.poll());
    }
}
