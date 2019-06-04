package com.cbr.java.lambda;

import org.junit.Test;

public class LazyTest {

    @Test
    public void testLazy() {
        final HolderNative holderNative = new HolderNative();
        System.out.println("deferring heavy creation..");
        System.out.println(holderNative.getHeavy());
        System.out.println(holderNative.getHeavy());
    }

    @Test
    public void testLazy2() {
        final HolderNative2 holder = new HolderNative2();
        System.out.println("deferring heavy creation...");
        System.out.println(holder.getHeavy());
        System.out.println(holder.getHeavy());
    }

    @Test
    public void testLazy3() {
        final String firstNameWith3Letters = Constants.NAMES.stream()
                .filter(name -> length(name) == 3)
                .map(name -> toUpper(name))
                .findFirst()
                .get();

        System.out.println(firstNameWith3Letters);
    }

    private static int length(final String name) {
        System.out.println("getting length for " + name);
        return name.length();
    }
    private static String toUpper(final String name ) {
        System.out.println("converting to uppercase: " + name);
        return name.toUpperCase();
    }
}