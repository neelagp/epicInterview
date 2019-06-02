package game.cache;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by NeelaGouda on 6/2/19.
 */
public class SimpleCache<K, V> {

    private ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();

    public void add(K key, V value) {
        cache.put(key, value);
    }

    public Map<K, V> getAll() {
        return new TreeMap<>(cache);
    }

    public Map<K, V> getAllSorted() {
        HashMap<K,V> map = new HashMap<>(cache);
        return sortMapByValue(map);
    }

    public V get(K key) {
        Objects.requireNonNull(key, "Cannot have null key for cache");
        return cache.get(key);
    }

    public boolean exists(K key) {
        return cache.containsKey(key);
    }

    public TreeMap<K, V> sortMapByValue(HashMap<K, V> map) {
        Comparator<K> comparator = new ValueComparator(map);
        TreeMap<K, V> result = new TreeMap<K, V>(comparator);
        result.putAll(map);
        return result;
    }


    class ValueComparator<K, V extends Comparable<V>> implements Comparator<K> {

        HashMap<K, V> map = new HashMap<K, V>();

        public ValueComparator(HashMap<K, V> map) {
            this.map.putAll(map);
        }

        @Override
        public int compare(K s1, K s2) {
            return -map.get(s1).compareTo(map.get(s2));//descending order
        }
    }

    //remove
    //clear
    //size
}
