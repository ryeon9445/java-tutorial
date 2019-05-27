package com.cbr.java.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class SetTest {

    @Test
    public void testHashSet() {
        HashSet<String> strings = new HashSet<>();

        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        strings.add("ccc");

        Assert.assertEquals(3, strings.size());
    }

    @Test
    public void testHashSetOfObject() {
        HashSet<CustomString> customStrings = new HashSet<>();
        customStrings.add(new CustomString("aaa"));
        customStrings.add(new CustomString("aaa"));

        Assert.assertEquals(1, customStrings.size());
    }

    private static class CustomString {

        public CustomString(String name) {
            this.name = name;
        }

        private String name;

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof CustomString) {
                CustomString customString = ((CustomString) obj);
                return name.equals(customString.name);
            }

            return false;
        }
    }
}