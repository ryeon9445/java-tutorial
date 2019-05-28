package com.cbr.java.lambda;

import org.junit.Test;

import java.util.stream.Collectors;

public class CollectTest {

    @Test
    public void testCollect() {
        String collect = Data.FRIENDS.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println(collect);
    }
}