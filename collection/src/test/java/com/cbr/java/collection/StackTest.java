package com.cbr.java.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class StackTest {

    @Test
    public void testStack() {
        Stack<Integer> integers = new Stack<>();
        integers.push(2);
        integers.push(4);
        integers.push(1);
        integers.push(3);

        Assert.assertEquals(3, integers.peek().intValue());
        Assert.assertEquals(4, integers.size());

        Assert.assertEquals(3, integers.pop().intValue());
        Assert.assertEquals(3, integers.size());

        Assert.assertEquals(1, integers.search(1));
        Assert.assertEquals(3, integers.search(2));
    }
}