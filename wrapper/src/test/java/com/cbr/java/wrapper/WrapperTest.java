package com.cbr.java.wrapper;

import org.junit.Assert;
import org.junit.Test;

public class WrapperTest {

    @Test
    public void testBoxing() {
        Integer number = new Integer(10);
        int num = number.intValue();
        Assert.assertEquals(10, num);
    }

    @Test
    public void testAutoBoxing() {
        Integer number = new Integer(10);
        Integer number2 = new Integer(10);
        int num = number;
        Assert.assertEquals(10, num);
        Assert.assertEquals(20, number + number2);
        Assert.assertEquals(number, number2);
        Assert.assertFalse(number == number2);
        Assert.assertTrue(number.equals(number2));
    }
}