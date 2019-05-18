package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {

    private final List<String> friends =
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    @Test
    public void testLambda() {
        List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12"));

        BigDecimal totalOfDiscountedPrices = prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Assert.assertEquals(67.5f, totalOfDiscountedPrices.floatValue(), 0);
    }

    @Test
    public void testFlow() {

        System.out.println("===== 1 =====");
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        System.out.println("===== 2 =====");
        for (String friend : friends) {
            System.out.println(friend);
        }

        System.out.println("===== 3 =====");
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(final String name) {
                System.out.println(name);
            }
        });

        System.out.println("===== 4 =====");
        friends.forEach((final String name) -> System.out.println(name));

        System.out.println("===== 5 =====");
        friends.forEach((name) -> System.out.println(name));

        System.out.println("===== 6 =====");
        friends.forEach(name -> System.out.println(name));

        System.out.println("===== 7 =====");
        friends.forEach(System.out::println);
    }

    @Test
    public void testMap() {
        friends.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.println(name + " "));
        System.out.println();
    }

    @Test
    public void testFilter() {
        long startsWithNCount = friends.stream()
                .filter(name -> name.startsWith("N"))
                .count();

        Assert.assertEquals(2, startsWithNCount);
    }
}