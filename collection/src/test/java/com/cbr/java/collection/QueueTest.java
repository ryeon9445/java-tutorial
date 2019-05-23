package com.cbr.java.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class QueueTest {

    @Test
    public void testQueue() {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("사");
        strings.add("일");
        strings.add("삼");
        strings.add("이");

        Assert.assertEquals("사", strings.peek());
        Assert.assertEquals(4, strings.size());

        Assert.assertEquals("사", strings.poll());
        Assert.assertEquals(3, strings.size());

        Assert.assertTrue(strings.remove("일"));
        Assert.assertEquals(2, strings.size());
    }
}