package inMemoryCache.solid.impl;

import inMemoryCache.solid.Cache;
import inMemoryCache.solid.EvictionPolicy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeCache <K, V> implements Cache<K, V> {
    private final int cacpcity;
    private final Map<K, V> store;
    private final EvictionPolicy<K> evictionPolicy;

    public ThreadSafeCache(int cacpcity, EvictionPolicy<K> evictionPolicy) {
        this.cacpcity = cacpcity;
        this.store = new ConcurrentHashMap<>();
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public synchronized void put(K key, V value) {
        if (store.size() >= cacpcity) {
            K evictedKey = evictionPolicy.evictKey();
            if (evictedKey != null) {
                store.remove(key, value);
            }
        }
        store.put(key, value);
        evictionPolicy.keyAccessed(key);
    }

    @Override
    public V get(K key) {
        V value = store.get(key);
        if (value != null) {
            evictionPolicy.keyAccessed(key);
        }
        return value;
    }

    @Override
    public synchronized void evict() {
        K evictedKey = evictionPolicy.evictKey();
        if (evictedKey != null) {
            store.remove(evictedKey);
        }
    }
}
