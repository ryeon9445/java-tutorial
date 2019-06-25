package com.cbr.java.algorithm;

import org.junit.Before;

public class MyBetterMapTest extends MyLinearMapTest {

    @Before
    public void setUp() {
        map = new MyBetterMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put(null, 0);
    }
}