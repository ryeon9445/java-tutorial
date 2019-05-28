package com.cbr.java.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class IteratorTest {

    @Test
    public void testIterator() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(2);

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("");

        ListIterator<Integer> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println("");

        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }
}