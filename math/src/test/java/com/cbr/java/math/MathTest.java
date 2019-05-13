package com.cbr.java.math;

import org.junit.Assert;
import org.junit.Test;

public class MathTest {

    @Test
    public void testRandom() {
        int random = (int) (Math.random() * 100);
        System.out.println(random);
        Assert.assertTrue(random > 0 && random < 100);
    }

    @Test
    public void testAbs() {
        Assert.assertEquals(10, Math.abs(-10));
    }

    @Test
    public void testCell() {
        Assert.assertEquals(10.0f, Math.ceil(10.0f), 0.0f);
        Assert.assertEquals(11.0f, Math.ceil(10.9f), 0.0f);
    }

    @Test
    public void testFloor() {
        Assert.assertEquals(10.0f, Math.floor(10.0f), 0.0f);
        Assert.assertEquals(10.0f, Math.floor(10.9f), 0.0f);
    }

    @Test
    public void testRound() {
        Assert.assertEquals(10.0f, Math.round(10.0f), 0.0f);
        Assert.assertEquals(10.0f, Math.round(10.4f), 0.0f);
        Assert.assertEquals(11.0f, Math.round(10.5f), 0.0f);
    }

    @Test
    public void testMax() {
        Assert.assertEquals(11,  Math.max(10, 11));
    }

    @Test
    public void testMin() {
        Assert.assertEquals(10, Math.min(10, 11));
    }

    @Test
    public void testPow() {
        Assert.assertEquals(100, (int) Math.pow(10, 2));
        Assert.assertEquals(1, (int) Math.pow(10, 0));
    }

    @Test
    public void testSqrt() {
        Assert.assertEquals(10, (int) Math.sqrt(100));
        Assert.assertEquals(3, (int) Math.sqrt(10));
    }

    @Test
    public void testSin() {
        System.out.println(Math.sin(Math.toRadians(30)));
        System.out.println(Math.sin(Math.PI / 6));
    }

    @Test
    public void testCos() {
        System.out.println(Math.tan(Math.toRadians(45)));
        System.out.println(Math.tan(Math.PI / 4));
    }

    @Test
    public void testTan() {
        System.out.println(Math.cos(Math.toRadians(60)));
        System.out.println(Math.cos(Math.PI / 3));
    }
}