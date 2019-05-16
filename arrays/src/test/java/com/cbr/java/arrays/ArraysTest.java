package com.cbr.java.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArraysTest {

    @Test
    public void testBinarySearch() {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertEquals(2, Arrays.binarySearch(intArray, 3));
    }

    @Test
    public void testCopyOf() {
        int[] intArray = {1, 2, 3, 4, 5};
        int[] intArrayOfCopy = Arrays.copyOf(intArray, 3);
        int[] intArrayOfCopy2 = Arrays.copyOf(intArray, 10);
        Assert.assertEquals(3, intArrayOfCopy.length);
        Assert.assertEquals(10, intArrayOfCopy2.length);
    }

    @Test
    public void testCopyOfRange() {
        int[] intArray = {1, 2, 3, 4, 5};
        int[] intArrayOfCopy = Arrays.copyOfRange(intArray, 2, 4);
        Arrays.stream(intArrayOfCopy).forEach(System.out::println);
        Assert.assertEquals(2, intArrayOfCopy.length);
    }

    @Test
    public void testFill() {
        int[] intArray = new int[10];
        Arrays.fill(intArray, 7);
        Assert.assertEquals(10, Arrays.stream(intArray)
                .filter(value -> value == 7)
                .count());
    }

    @Test
    public void testSort() {
        int[] intArray = {2, 4, 5, 1, 3};
        Arrays.sort(intArray);
        Arrays.stream(intArray).forEach(System.out::println);
        Assert.assertEquals(1, Arrays.stream(intArray).findFirst().getAsInt());
    }
}