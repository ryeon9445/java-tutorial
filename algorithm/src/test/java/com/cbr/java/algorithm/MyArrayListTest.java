package com.cbr.java.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class MyArrayListTest {

    private List<Integer> myList;
    private List<Integer> list;

    @Before
    public void setUp(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        myList = new MyArrayList<>();
        myList.addAll(list);
    }

    @Test
    public void testMyList() {
        Assert.assertThat(myList.size(), is(3));
    }
}