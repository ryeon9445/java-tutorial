package com.cbr.java.algorithm.sort;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListSorterTest {

    private ListSorter<Integer> sorter;
    private Comparator<Integer> comparator;

    @Before
    public void setUp() {
        comparator = Integer::compareTo;
        sorter = new ListSorter<>();
    }

    @Test
    public void testInsertionSort() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 5, 1, 4, 2));
        sorter.insertionSort(list, comparator);
        isSorted(list);
    }

    private void isSorted(List<Integer> list) {
        Assert.assertThat(list.size(), Is.is(5));
        Assert.assertThat(list.get(0), Is.is(1));
        Assert.assertThat(list.get(1), Is.is(2));
        Assert.assertThat(list.get(2), Is.is(3));
        Assert.assertThat(list.get(3), Is.is(4));
        Assert.assertThat(list.get(4), Is.is(5));
    }

    @Test
    public void testMergeSortInPlace() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 4, 2));
        sorter.mergeSortInPlace(list, comparator);
        isSorted(list);
    }

    @Test
    public void testMergeSort() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 5, 1, 4, 2));
        List<Integer> sorted = sorter.mergeSort(list, comparator);
        isSorted(sorted);
    }

    @Test
    public void testHeapSort() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 5, 1, 4, 2));
        sorter.heapSort(list, comparator);
        isSorted(list);
    }

    @Test
    public void testTopK() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(6, 3, 5, 8, 1, 4, 2, 7));
        List<Integer> res = sorter.topK(4, list, comparator);
        Assert.assertThat(res.size(), Is.is(4));
        Assert.assertThat(res.get(0), Is.is(5));
        Assert.assertThat(res.get(1), Is.is(6));
        Assert.assertThat(res.get(2), Is.is(7));
        Assert.assertThat(res.get(3), Is.is(8));
    }
}