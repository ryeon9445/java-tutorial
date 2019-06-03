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
}