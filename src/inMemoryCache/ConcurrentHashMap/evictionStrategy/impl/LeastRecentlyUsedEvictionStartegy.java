package inMemoryCache.ConcurrentHashMap.evictionStrategy.impl;

import inMemoryCache.ConcurrentHashMap.evictionStrategy.EvictionStrategy;

import java.util.LinkedHashMap;
import java.util.Optional;

public class LeastRecentlyUsedEvictionStartegy<K> implements EvictionStrategy<K> {
    private final LinkedHashMap<K, Boolean> order;
    public LeastRecentlyUsedEvictionStartegy() {
        this.order = new LinkedHashMap<>(16, 0.75f, true);
    }
    @Override
    public void keyAccessed(K key) {
        order.put(key, true);
    }

    @Override
    public Optional<K> evictKey() {
        if (order.isEmpty()) {
            return Optional.empty();
        }
        K eldestKey = order.keySet().iterator().next();
        order.remove(eldestKey);
        return Optional.of(eldestKey);
    }
}
