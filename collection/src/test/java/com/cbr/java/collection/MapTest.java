package com.cbr.java.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.TreeMap;

public class MapTest {

    @Test
    public void testHashMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("one", 1);
        hashMap.put("four", 4);
        hashMap.put("three", 3);
        hashMap.put("two", 2);

        System.out.println(hashMap);
        Assert.assertEquals(4, hashMap.size());

        hashMap.remove("three");
        Assert.assertEquals(3, hashMap.size());

        hashMap.replace("two", 22);
        Assert.assertEquals(hashMap.get("two").intValue(), 22);

    }

    @Test
    public void testTreeMap() {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        treeMap.put("one", 1);
        treeMap.put("four", 4);
        treeMap.put("three", 3);
        treeMap.put("two", 2);

        Assert.assertEquals(4, treeMap.size());

        treeMap.remove("two");
        Assert.assertEquals(3, treeMap.size());
    }
}