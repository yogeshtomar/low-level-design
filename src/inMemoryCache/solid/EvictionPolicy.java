package inMemoryCache.solid;

public interface EvictionPolicy <K> {
    void keyAccessed(K key);
    K evictKey();
}
