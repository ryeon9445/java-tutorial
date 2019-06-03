package com.cbr.java.lambda;

public class HolderNative {

    private Heavy heavy;

    public HolderNative() {
        System.out.println("Holder created");
    }

    public synchronized Heavy getHeavy() {
        if (heavy == null) {
            heavy = new Heavy();
        }

        return heavy;
    }
}