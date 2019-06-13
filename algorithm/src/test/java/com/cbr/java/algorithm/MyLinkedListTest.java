package com.cbr.java.algorithm;

import org.junit.Before;

import java.util.ArrayList;

public class MyLinkedListTest extends MyArrayListTest {

    @Before
    public void setUp() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        myList = new MyLinkedList<>();
        myList.addAll(list);
    }
}