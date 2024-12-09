package inMemoryCache.ConcurrentHashMap.evictionStrategy;

import java.util.Optional;

public interface EvictionStrategy<K> {
    void keyAccessed(K key);

    Optional<K> evictKey();
}
