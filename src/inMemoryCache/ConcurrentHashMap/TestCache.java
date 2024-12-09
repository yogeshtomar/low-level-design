package inMemoryCache.ConcurrentHashMap;

import inMemoryCache.ConcurrentHashMap.cache.Cache;
import inMemoryCache.ConcurrentHashMap.evictionStrategy.impl.LeastFrequentlyUsedEvictionStrategy;
import inMemoryCache.ConcurrentHashMap.evictionStrategy.impl.LeastRecentlyUsedEvictionStartegy;

public class TestCache {
    public static void main(String[] args) {
        Cache<String, String> lruCache = new Cache<>(3, new LeastRecentlyUsedEvictionStartegy<>());

        lruCache.put("A", "Apple");
        lruCache.put("B", "Banana");
        lruCache.put("C", "Cherry");

        System.out.println(lruCache.get("A"));
        lruCache.put("D", "Dates");

        System.out.println(lruCache.get("B"));
        System.out.println(lruCache.get("A"));

        Cache<String, String> lfuCache = new Cache<>(2, new LeastFrequentlyUsedEvictionStrategy<>());
        lfuCache.put("X", "X-ray");
        lfuCache.put("Y", "Yam");
        lfuCache.get("X"); // Access "X" to increase frequency
        lfuCache.put("Z", "Zebra"); // Evicts "Y" (Least Frequently Used)

        System.out.println(lfuCache.get("Y")); // null
        System.out.println(lfuCache.get("X")); // X-ray
    }
}
