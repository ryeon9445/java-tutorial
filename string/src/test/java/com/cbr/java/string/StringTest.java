package com.cbr.java.string;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {

    private String text = "Hello World";

    @Test
    public void testCompareTo() {
        Assert.assertEquals(-1, text.compareTo("Hello World!"));
        Assert.assertEquals(6, text.compareTo("Hello"));
        Assert.assertEquals(0, text.compareTo("Hello World"));
        Assert.assertEquals(0, text.compareToIgnoreCase("HELLO WORLD"));
    }

    @Test
    public void testConcat() {
        Assert.assertEquals("Hello World!", text.concat("!"));
    }

    @Test
    public void testIndexOf() {
        Assert.assertEquals(6, text.indexOf('W'));
        Assert.assertEquals(6, text.indexOf("World"));
        Assert.assertEquals(-1, text.indexOf('w'));
        Assert.assertEquals(7, text.lastIndexOf('o'));
        Assert.assertEquals(7, text.lastIndexOf("orld"));
        Assert.assertEquals(-1, text.lastIndexOf('w'));
    }

    @Test
    public void testTrim() {
        String blankText = text.concat(" ");
        Assert.assertNotEquals(text, blankText);
        Assert.assertEquals(blankText.trim(), text);
    }

    @Test
    public void testToLowerCase() {
        Assert.assertEquals("hello world", text.toLowerCase());
    }

    @Test
    public void testToUpperCase() {
        Assert.assertEquals("HELLO WORLD", text.toUpperCase());
    }
}