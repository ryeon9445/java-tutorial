package com.cbr.java.algorithm;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class SelectionSortTest {

    @Test
    public void testSort() {
        int[] array = {2, 5, 6, 1, 3};
        SelectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static class SelectionSort {

        public static void swapElements(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public static int indexLowest(int[] array, int start) {
            return IntStream.range(0, array.length)
                    .skip(start)
                    .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, array[i]))
                    .min(Comparator.comparingInt(AbstractMap.SimpleEntry::getValue))
                    .map(AbstractMap.SimpleEntry::getKey)
                    .orElse(-1);
        }

        public static void selectionSort(int[] array) {
            for (int i = 0; i < array.length; i++) {
                int j = indexLowest(array, i);
                swapElements(array, i, j);
            }
        }
    }
}