package com.cbr.java.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparableTest {

    @Test
    public void testComparable() {
        Index index01 = new Index(3);
        Index index02 = new Index(5);
        Index index03 = new Index(3);
        Index index04 = new Index(1);


        Assert.assertEquals(-1, index01.compareTo(index02));
        Assert.assertEquals(0, index01.compareTo(index03));
        Assert.assertEquals(1, index01.compareTo(index04));
    }

    @Test
    public void testComparator() {
        TreeSet<Integer> integers = new TreeSet<Integer>(new DescendingOrder());

        integers.add(3);
        integers.add(4);
        integers.add(2);
        integers.add(1);

        System.out.println(integers);
    }

    class Index implements Comparable<Index> {

        private int index;

        public Index(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(Index index) {
//            return Integer.compare(this.index, index.index);
            if (this.index == index.index) {
                return 0;
            } else if (this.index < index.index) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    class DescendingOrder implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 != null && o2 != null) {
                return o2.compareTo(o1);
            }
            return -1;
        }
    }
}