package com.cbr.java.lambda;

public class Assert {

    public enum AssetType {

        BOND,
        STOCK
    }

    private final AssetType type;
    private final int value;

    public Assert(AssetType type, int value) {
        this.type = type;
        this.value = value;
    }

    public AssetType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}