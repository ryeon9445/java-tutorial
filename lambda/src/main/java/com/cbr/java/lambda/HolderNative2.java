package com.cbr.java.lambda;

import java.util.function.Supplier;

public class HolderNative2 {

    private Supplier<Heavy> heavy = () -> createAndCacheHeavy();

    public HolderNative2() {
        System.out.println("Holder created");
    }

    public Heavy getHeavy() {
        return heavy.get();
    }

    private synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier<Heavy> {

            private final Heavy heavyInstance = new Heavy();

            public Heavy get() {
                return heavyInstance;
            }
        }

        if (!HeavyFactory.class.isInstance(heavy)) {
            heavy = new HeavyFactory();
        }
        return heavy.get();
    }
}