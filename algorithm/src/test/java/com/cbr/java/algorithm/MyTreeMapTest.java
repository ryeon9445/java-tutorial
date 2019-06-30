package com.cbr.java.algorithm;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class MyTreeMapTest {

    private MyTreeMap<String, Integer> map;

    @Before
    public void setUp() throws Exception {
        map = new MyTreeMap<>();
        MyTreeMap<String, Integer>.Node node08 = map.makeNode("08", 8);
        MyTreeMap<String, Integer>.Node node03 = map.makeNode("03", 3);
        MyTreeMap<String, Integer>.Node node10 = map.makeNode("10", 10);

        node08.left = node03;
        node08.right = node10;

        MyTreeMap<String, Integer>.Node node01 = map.makeNode("01", 1);
        MyTreeMap<String, Integer>.Node node06 = map.makeNode("06", 6);
        MyTreeMap<String, Integer>.Node node14 = map.makeNode("14", 14);

        node03.left = node01;
        node03.right = node06;
        node10.right = node14;

        MyTreeMap<String, Integer>.Node node04 = map.makeNode("04", 4);
        MyTreeMap<String, Integer>.Node node07 = map.makeNode("07", 7);
        MyTreeMap<String, Integer>.Node node13 = map.makeNode("13", 13);

        node06.left = node04;
        node06.right = node07;
        node14.left = node13;

        map.setTree(node08, 9);
    }

    @Test
    public void testClear() {
        map.clear();
        Assert.assertThat(map.size(), Is.is(0));
    }

    @Test
    public void testContainsKey() {
        Assert.assertThat(map.containsKey("03"), Is.is(true));
        Assert.assertThat(map.containsKey("05"), Is.is(false));
    }

    @Test
    public void testContainsValue() {
        Assert.assertThat(map.containsValue(3), Is.is(true));
        Assert.assertThat(map.containsValue(5), Is.is(false));
    }

    @Test
    public void testGet() {
        Assert.assertThat(map.get("01"), Is.is(1));
        Assert.assertThat(map.get("03"), Is.is(3));
        Assert.assertThat(map.get("04"), Is.is(4));
        Assert.assertThat(map.get("06"), Is.is(6));
        Assert.assertThat(map.get("07"), Is.is(7));
        Assert.assertThat(map.get("08"), Is.is(8));
        Assert.assertThat(map.get("10"), Is.is(10));
        Assert.assertThat(map.get("13"), Is.is(13));
        Assert.assertThat(map.get("14"), Is.is(14));

        Assert.assertThat(map.get("02"), IsNull.nullValue());
        Assert.assertThat(map.get("05"), IsNull.nullValue());
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
        Assert.assertThat(keySet.size(), Is.is(9));
        Assert.assertThat(keySet.contains("03"), Is.is(true));
        Assert.assertThat(keySet.contains("05"), Is.is(false));

        List<String> list = new ArrayList<>();
        list.addAll(keySet);

        for (int i = 0; i < list.size()-1; i++) {
            System.out.println(list.get(i));
            if (list.get(i).compareTo(list.get(i+1)) > 0) {
                assert(false);
            }
        }
    }

    @Test
    public void testPut() {
        map.put("06", 66);
        Assert.assertThat(map.size(), Is.is(9));
        Assert.assertThat(map.get("06"), Is.is(66));

        map.put("05", 5);
        Assert.assertThat(map.size(), Is.is(10));
        Assert.assertThat(map.get("05"), Is.is(5));
    }

    @Test
    public void testPutAll() {
        Map<String, Integer> m = new HashMap<String, Integer>();
        m.put("02", 2);
        m.put("05", 5);
        m.put("12", 12);
        map.putAll(m);
        Assert.assertThat(map.size(), Is.is(12));
    }

    @Test
    public void testRemove() {

    }

    @Test
    public void testSize() {
        Assert.assertThat(map.size(), Is.is(9));
    }

    @Test
    public void testValues() {
        Collection<Integer> keySet = map.values();
        Assert.assertThat(keySet.size(), Is.is(9));
        Assert.assertThat(keySet.contains(3), Is.is(true));
        Assert.assertThat(keySet.contains(5), Is.is(false));
    }
}