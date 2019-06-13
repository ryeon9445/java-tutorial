package com.cbr.java.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class MyArrayListTest {

    protected List<Integer> myList;
    protected List<Integer> list;

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

    @Test
    public void testAddT() {
        for (int i = 4; i < 20; i++) {
            myList.add(i);
        }
        Assert.assertThat(myList.get(18), is(19));
    }

    @Test
    public void testAddIntT() {
        myList.add(1, 5);
        Assert.assertThat(myList.get(1), is(5));
        Assert.assertThat(myList.size(), is(4));

        try {
            myList.set(-1, 0);
            Assert.fail();
        } catch (IndexOutOfBoundsException ignore) {}

        try {
            myList.set(4, 0);
            Assert.fail();
        } catch (IndexOutOfBoundsException ignore) {}

        myList.add(0, 6);
        Assert.assertThat(myList.get(0), is(6));

        myList.add(5, 7);
        Assert.assertThat(myList.get(0), is(6));
    }

    @Test
    public void testAddAllCollectionOfQextendsT() {
        myList.addAll(list);
        myList.addAll(list);
        myList.addAll(list);
        Assert.assertThat(myList.size(), is(12));
        Assert.assertThat(myList.get(5), is(3));
    }

    @Test
    public void testClear() {
        myList.clear();
        Assert.assertThat(myList.size(), is(0));
    }

    @Test
    public void testContains() {
        Assert.assertThat(myList.contains(1), equalTo(true));
        Assert.assertThat(myList.contains(4), equalTo(false));
        Assert.assertThat(myList.contains(null), equalTo(false));
        myList.add(null);
        Assert.assertThat(myList.contains(null), equalTo(true));
    }

    @Test
    public void testContainsAll() {
        Assert.assertThat(myList.containsAll(list), equalTo(true));
    }

    @Test
    public void testGet() {
        Assert.assertThat(myList.get(1), is(2));
    }

    @Test
    public void testIndexOf() {
        Assert.assertThat(myList.indexOf(1), is(0));
        Assert.assertThat(myList.indexOf(2), is(1));
        Assert.assertThat(myList.indexOf(3), is(2));
        Assert.assertThat(myList.indexOf(4), is(-1));
    }

    @Test
    public void testIndexOfNull() {
        Assert.assertThat(myList.indexOf(null), is(-1));
        myList.add(null);
        Assert.assertThat(myList.indexOf(null), is(3));
    }

    @Test
    public void testIsEmpty() {
        Assert.assertThat(myList.isEmpty(), equalTo(false));
        myList.clear();
        Assert.assertThat(myList.isEmpty(), equalTo(true));
    }

    @Test
    public void testIterator() {
        Iterator<Integer> iter = myList.iterator();
        Assert.assertThat(iter.next(), is(1));
        Assert.assertThat(iter.next(), is(2));
        Assert.assertThat(iter.next(), is(3));
        Assert.assertThat(iter.hasNext(), equalTo(false));
    }

    @Test
    public void testLastIndexOf() {
        myList.add(2);
        Assert.assertThat(myList.lastIndexOf(2), is(3));
    }

    @Test
    public void testRemoveObject() {
        boolean flag = myList.remove(new Integer(2));
        Assert.assertThat(flag, equalTo(true));
        Assert.assertThat(myList.size(), is(2));
        Assert.assertThat(myList.get(1), is(3));
        System.out.println(Arrays.toString(myList.toArray()));

        flag = myList.remove(new Integer(1));
        Assert.assertThat(flag, equalTo(true));
        Assert.assertThat(myList.size(), is(1));
        Assert.assertThat(myList.get(0), is(3));

        flag = myList.remove(new Integer(5));
        Assert.assertThat(flag, equalTo(false));
        Assert.assertThat(myList.size(), is(1));
        Assert.assertThat(myList.get(0), is(3));

        flag = myList.remove(new Integer(3));
        Assert.assertThat(flag, equalTo(true));
        Assert.assertThat(myList.size(), is(0));
    }

    @Test
    public void testRemoveInt() {
        Integer val = myList.remove(1);
        Assert.assertThat(val, is(2));
        Assert.assertThat(myList.size(), is(2));
        Assert.assertThat(myList.get(1), is(3));
    }

    @Test
    public void testRemoveAll() {
        myList.removeAll(list);
        Assert.assertThat(myList.size(), is(0));
    }

    @Test
    public void testSet() {
        Integer val = myList.set(1, 5);
        Assert.assertThat(val, is(2));

        val = myList.set(0, 6);
        Assert.assertThat(val, is(1));

        val = myList.set(2, 7);
        Assert.assertThat(val, is(3));

        Assert.assertThat(myList.get(0), is(6));
        Assert.assertThat(myList.get(1), is(5));
        Assert.assertThat(myList.get(2), is(7));

        try {
            myList.set(-1, 0);
            Assert.fail();
        } catch (IndexOutOfBoundsException ignore) {}

        try {
            myList.set(4, 0);
            Assert.fail();
        } catch (IndexOutOfBoundsException ignore) {}
    }

    @Test
    public void testSize() {
        Assert.assertThat(myList.size(), is(3));
    }

    @Test
    public void testSubList() {
        myList.addAll(list);
        List<Integer> sub = myList.subList(1, 4);
        Assert.assertThat(sub.get(1), is(3));
    }

    @Test
    public void testToArray() {
        Object[] array = myList.toArray();
        Assert.assertThat(array[0], is(1));
    }
}