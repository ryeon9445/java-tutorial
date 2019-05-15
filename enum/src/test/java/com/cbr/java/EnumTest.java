package com.cbr.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class EnumTest {

    enum Rainbow {
        RED(1),
        ORANGE(2),
        YELLOW(3),
        GREEN(4),
        BLUE(5),
        INDIGO(6),
        VIOLET(7);

        private final int index;

        Rainbow(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    @Test
    public void testEnum() {
        Assert.assertEquals(1, Rainbow.RED.getIndex());
    }

    @Test
    public void testValues() {
        Arrays.stream(Rainbow.values()).forEach(System.out::println);
    }

    @Test
    public void testValueOf() {
        Rainbow rainbow = Rainbow.valueOf("RED");
        Assert.assertNotNull(rainbow);
        Assert.assertEquals(1, rainbow.getIndex());
    }
}