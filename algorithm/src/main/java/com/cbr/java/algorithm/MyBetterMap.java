package com.cbr.java.algorithm;

import java.util.*;

public class MyBetterMap<K, V> implements Map<K, V> {

    protected List<MyLinearMap<K, V>> maps;

    public MyBetterMap() {
        makeMaps(2);
    }

    protected void makeMaps(int k) {
        maps = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            maps.add(new MyLinearMap<K, V>());
        }
    }

    public void clear() {
        for (int i = 0; i < maps.size(); i++) {
            maps.get(i).clear();
        }
    }

    protected MyLinearMap<K, V> chooseMap(Object key) {
        int index = key==null ? 0 : Math.abs(key.hashCode()) % maps.size();
        return maps.get(index);
    }

    @Override
    public boolean containsKey(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (MyLinearMap<K, V> map: maps) {
            if (map.containsValue(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V get(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.get(key);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (MyLinearMap<K, V> map : maps) {
            set.addAll(map.keySet());
        }
        return set;
    }

    @Override
    public V put(K key, V value) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.put(key, value);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V remove(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.remove(key);
    }

    @Override
    public int size() {
        int total = 0;
        for (MyLinearMap<K, V> map : maps) {
            total += map.size();
        }
        return total;
    }

    @Override
    public Collection<V> values() {
        Set<V> set = new HashSet<>();
        for (MyLinearMap<K, V> map : maps) {
            set.addAll(map.values());
        }
        return set;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new MyBetterMap<>();
        map.put("Word1", 1);
        map.put("Word2", 2);
        Integer value = map.get("Word1");
        System.out.println(value);

        map.keySet().stream()
                .map(key -> key + ", " + map.get(key))
                .forEach(System.out::println);
    }
}