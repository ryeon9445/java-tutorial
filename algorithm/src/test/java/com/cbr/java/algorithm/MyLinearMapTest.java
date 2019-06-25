package com.cbr.java.algorithm;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyLinearMapTest {

    protected Map<String, Integer> map;

    @Before
    public void setUp() throws Exception {
        map = new MyLinearMap<String, Integer>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put(null, 0);
    }

    @Test
    public void testClear() {
        map.clear();
        Assert.assertThat(map.size(), Is.is(0));
    }

    @Test
    public void testContainsKey() {
        Assert.assertThat(map.containsKey("Three"), Is.is(true));
        Assert.assertThat(map.containsKey(null), Is.is(true));
        Assert.assertThat(map.containsKey("Fore"), Is.is(false));
    }

    @Test
    public void testGet() {
        Assert.assertThat(map.get("Three"), Is.is(3));
        Assert.assertThat(map.get(null), Is.is(0));
        Assert.assertThat(map.get("Fore"), IsNull.nullValue());
    }

    @Test
    public void testIsEmpty() {
        Assert.assertThat(map.isEmpty(), Is.is(false));
        map.clear();
        Assert.assertThat(map.isEmpty(), Is.is(true));
    }

    @Test
    public void testKeySet() {
        Set<String> keySet = map.keySet();
        Assert.assertThat(keySet.size(), Is.is(4));
        Assert.assertThat(keySet.contains("Three"), Is.is(true));
        Assert.assertThat(keySet.contains(null), Is.is(true));
        Assert.assertThat(keySet.contains("Fore"), Is.is(false));
    }

    @Test
    public void testPut() {
        map.put("One", 11);
        Assert.assertThat(map.size(), Is.is(4));
        Assert.assertThat(map.get("One"), Is.is(11));

        map.put("Five", 5);
        Assert.assertThat(map.size(), Is.is(5));
        Assert.assertThat(map.get("Five"), Is.is(5));
    }

    @Test
    public void testPutAll() {
        Map<String, Integer> m = new HashMap<String, Integer>();
        m.put("Six", 6);
        m.put("Seven", 7);
        m.put("Eight", 8);
        map.putAll(m);
        Assert.assertThat(map.size(), Is.is(7));
    }

    @Test
    public void testRemove() {
        map.remove("One");
        Assert.assertThat(map.size(), Is.is(3));
        Assert.assertThat(map.get("One"), IsNull.nullValue());
    }

    @Test
    public void testSize() {
        Assert.assertThat(map.size(), Is.is(4));
    }

    @Test
    public void testValues() {
        Collection<Integer> keySet = map.values();
        Assert.assertThat(keySet.size(), Is.is(4));
        Assert.assertThat(keySet.contains(3), Is.is(true));
        Assert.assertThat(keySet.contains(0), Is.is(true));
        Assert.assertThat(keySet.contains(4), Is.is(false));
    }
}