package com.cbr.java.algorithm;

import java.util.*;

public class MyLinearMap<K, V> implements Map<K, V> {

    private List<Entry> entries = new ArrayList<>();

    public class Entry implements Map.Entry<K, V> {

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }

    @Override
    public void clear() {
        entries.clear();
    }

    @Override
    public boolean containsKey(Object target) {
        return findEntry(target) != null;
    }

    /**
     * O(n)
     */
    private Entry findEntry(Object target) {
        for (Entry entry: entries) {
            if (equals(target, entry.getKey())) {
                return entry;
            }
        }
        return null;
    }

    /**
     * O(1)
     */
    private boolean equals(Object target, Object obj) {
        if (target == null) {
            return obj == null;
        }
        return target.equals(obj);
    }

    @Override
    public boolean containsValue(Object target) {
        for (Map.Entry<K, V> entry: entries) {
            if (equals(target, entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    /**
     * O(n)
     */
    @Override
    public V get(Object key) {
        Entry entry = findEntry(key);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Entry entry: entries) {
            set.add(entry.getKey());
        }
        return set;
    }

    /**
     * O(n)
     */
    @Override
    public V put(K key, V value) {
        Entry entry = findEntry(key);
        if (entry == null) {
            entries.add(new Entry(key, value));
            return null;
        } else {
            V oldValue = entry.getValue();
            entry.setValue(value);
            return oldValue;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry: m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V remove(Object key) {
        Entry entry = findEntry(key);
        if (entry == null) {
            return null;
        } else {
            V value = entry.getValue();
            entries.remove(entry);
            return value;
        }
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public Collection<V> values() {
        Set<V> set = new HashSet<>();
        for (Entry entry: entries) {
            set.add(entry.getValue());
        }
        return set;
    }

    protected Collection<? extends Map.Entry<K, V>> getEntries() {
        return entries;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new MyLinearMap<>();
        map.put("Word1", 1);
        map.put("Word2", 2);
        Integer value = map.get("Word2");
        System.out.println(value);

        for (String key: map.keySet()) {
            System.out.println(key + ", " + map.get(key));
        }
    }
}