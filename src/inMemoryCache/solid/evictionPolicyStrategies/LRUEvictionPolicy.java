package inMemoryCache.solid.evictionPolicyStrategies;

import inMemoryCache.solid.EvictionPolicy;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    private final Map<K, Boolean> accessOrder;

    public LRUEvictionPolicy() {
        this.accessOrder = new LinkedHashMap<>(16, 0.75f, true);
    }

    @Override
    public void keyAccessed(K key) {
        accessOrder.put(key, true);
    }

    @Override
    public K evictKey() {
        if (accessOrder.isEmpty()) {
            return null;
        }
        return accessOrder.keySet().iterator().next();
    }
}
