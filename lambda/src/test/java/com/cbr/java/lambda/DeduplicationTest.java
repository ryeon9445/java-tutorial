package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

public class DeduplicationTest {

    @Test
    public void testDuplication() {
        final long countFriendsStartN = Data.FRIENDS.stream()
                .filter(name -> name.startsWith("N")).count();
        Assert.assertEquals(2, countFriendsStartN);

        final long countEditorsStartN = Data.EDITORS.stream()
                .filter(name -> name.startsWith("N")).count();
        Assert.assertEquals(0, countEditorsStartN);

        final long countComradesStartN = Data.COMRADES.stream()
                .filter(name -> name.startsWith("N")).count();
        Assert.assertEquals(1, countComradesStartN);
    }

    @Test
    public void testDeduplication01() {
        final Predicate<String> startsWithN = name -> name.startsWith("N");

        final long countFriendsStartN = Data.FRIENDS.stream()
                .filter(startsWithN)
                .count();
        Assert.assertEquals(2, countFriendsStartN);

        final long countEditorsStartN = Data.EDITORS.stream()
                .filter(startsWithN)
                .count();
        Assert.assertEquals(0, countEditorsStartN);

        final long countComradesStartN = Data.COMRADES.stream()
                .filter(startsWithN)
                .count();
        Assert.assertEquals(1, countComradesStartN);
    }

    @Test
    public void testDeduplication02() {
        final long countFriendsStartN = Data.FRIENDS.stream()
                .filter(checkIfStartsWith("N")).count();
        Assert.assertEquals(2, countFriendsStartN);

        final long countFriendsStartB = Data.FRIENDS.stream()
                .filter(checkIfStartsWith("B")).count();
        Assert.assertEquals(1, countFriendsStartB);
    }

    @Test
    public void testDeduplicationFinal() {
        final Function<String, Predicate<String>> startsWithLetter =
                letter -> name -> name.startsWith(letter);

        final long countFriendsStartN = Data.FRIENDS.stream()
                .filter(startsWithLetter.apply("N")).count();
        Assert.assertEquals(2, countFriendsStartN);

        final long countFriendsStartB = Data.FRIENDS.stream()
                .filter(startsWithLetter.apply("B")).count();
        Assert.assertEquals(1, countFriendsStartB);
    }

    private Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }
}