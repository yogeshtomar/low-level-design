package inMemoryCache.ConcurrentHashMap.cache;

import inMemoryCache.ConcurrentHashMap.evictionStrategy.EvictionStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache<K, V> {
    private final int capacity;
    private final Map<K, V> store;
    private final EvictionStrategy<K> evictionStrategy;

    public Cache(int capacity, EvictionStrategy<K> evictionStrategy) {
        this.capacity = capacity;
        this.store = new ConcurrentHashMap<>(capacity);
        this.evictionStrategy = evictionStrategy;
    }

    public void put(K key, V value) {
        if (store.size() >= capacity) {
            evictionStrategy.evictKey().ifPresent(store::remove);
        }
        store.put(key, value);
        evictionStrategy.keyAccessed(key);
    }

    public V get(K key) {
        if (store.containsKey(key)) {
            evictionStrategy.keyAccessed(key);
        }
        return store.get(key);
    }


    public void remove(K key) {
        store.remove(key);
    }

    public int size() {
        return store.size();
    }

    public void clear() {
        store.clear();
    }

    public boolean isEmpty() {
        return store.isEmpty();
    }

}
