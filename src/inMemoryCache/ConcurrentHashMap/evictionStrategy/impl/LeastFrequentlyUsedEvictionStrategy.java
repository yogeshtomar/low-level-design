package inMemoryCache.ConcurrentHashMap.evictionStrategy.impl;

import inMemoryCache.ConcurrentHashMap.evictionStrategy.EvictionStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LeastFrequentlyUsedEvictionStrategy <K> implements EvictionStrategy<K> {
    private final Map<K, Integer> frequencyMap;

    public LeastFrequentlyUsedEvictionStrategy() {
        this.frequencyMap = new HashMap<>();
    }

    @Override
    public void keyAccessed(K key) {
        frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
    }

    @Override
    public Optional<K> evictKey() {
        if (frequencyMap.isEmpty()) {
            return Optional.empty();
        }

        K leastFrequentKey = frequencyMap.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        if (leastFrequentKey != null) {
            frequencyMap.remove(leastFrequentKey);
        }
        return Optional.ofNullable(leastFrequentKey);
    }
}
