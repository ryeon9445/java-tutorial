package com.cbr.java.stringbuffer;

import org.junit.Assert;
import org.junit.Test;

public class StringBufferTest {

    private StringBuffer text = new StringBuffer("Hello World");

    @Test
    public void testAppend() {
        String appendText = text.append("!").toString();
        Assert.assertEquals("Hello World!", appendText);
    }

    @Test
    public void testCapacity() {
        Assert.assertEquals(16 + 11, text.capacity());
    }

    @Test
    public void testDelete() {
        Assert.assertEquals("Hello", text.delete(5, 11).toString());
        Assert.assertEquals("Hell", text.deleteCharAt(4).toString());
    }

    @Test
    public void testInsert() {
        Assert.assertEquals("Hello World!", text.insert(11, "!").toString());
    }

    @Test
    public void testReverse() {
        Assert.assertEquals("dlroW olleH", text.reverse().toString());
    }
}