package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {

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
        for (int i = 0; i < Data.FRIENDS.size(); i++) {
            System.out.println(Data.FRIENDS.get(i));
        }

        System.out.println("===== 2 =====");
        for (String friend : Data.FRIENDS) {
            System.out.println(friend);
        }

        System.out.println("===== 3 =====");
        Data.FRIENDS.forEach(new Consumer<String>() {
            @Override
            public void accept(final String name) {
                System.out.println(name);
            }
        });

        System.out.println("===== 4 =====");
        Data.FRIENDS.forEach((final String name) -> System.out.println(name));

        System.out.println("===== 5 =====");
        Data.FRIENDS.forEach((name) -> System.out.println(name));

        System.out.println("===== 6 =====");
        Data.FRIENDS.forEach(name -> System.out.println(name));

        System.out.println("===== 7 =====");
        Data.FRIENDS.forEach(System.out::println);
    }

    @Test
    public void testMap() {
        Data.FRIENDS.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.println(name + " "));
        System.out.println();
    }

    @Test
    public void testFilter() {
        long startsWithNCount = Data.FRIENDS.stream()
                .filter(name -> name.startsWith("N"))
                .count();

        Assert.assertEquals(2, startsWithNCount);
    }

    @Test
    public void testIteratorString() {
        final String str = "w00t";

        str.chars()
                .mapToObj(ch -> (char) ch)
                .forEach(System.out::println);

        System.out.println("");

        str.chars()
                .filter(Character::isDigit)
                .mapToObj(ch -> (char) ch)
                .forEach(System.out::println);
    }
}