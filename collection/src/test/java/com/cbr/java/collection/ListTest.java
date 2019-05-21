package com.cbr.java.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    @Test
    public void testList() {
        List<Integer> integers = new ArrayList<>();

        integers.add(4);
        integers.add(2);
        integers.add(3);
        integers.add(1);

        Assert.assertEquals(4, integers.size());
        integers.remove(1);
        Assert.assertEquals(3, integers.size());
        Collections.sort(integers);

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }

        integers.set(0, 9);
        Assert.assertEquals(9, integers.stream().findFirst().orElse(0).intValue());
    }
}