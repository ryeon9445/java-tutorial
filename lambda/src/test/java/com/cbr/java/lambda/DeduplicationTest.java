package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DeduplicationTest {

    private final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    private final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");
    private final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

    private Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

    @Test
    public void testDuplication() {
        final long countFriendsStartN = friends.stream()
                .filter(name -> name.startsWith("N")).count();
        Assert.assertEquals(2, countFriendsStartN);

        final long countEditorsStartN = editors.stream()
                .filter(name -> name.startsWith("N")).count();
        Assert.assertEquals(0, countEditorsStartN);

        final long countComradesStartN = comrades.stream()
                .filter(name -> name.startsWith("N")).count();
        Assert.assertEquals(1, countComradesStartN);
    }

    @Test
    public void testDeduplication01() {
        final Predicate<String> startsWithN = name -> name.startsWith("N");

        final long countFriendsStartN = friends.stream()
                .filter(startsWithN)
                .count();
        Assert.assertEquals(2, countFriendsStartN);

        final long countEditorsStartN = editors.stream()
                .filter(startsWithN)
                .count();
        Assert.assertEquals(0, countEditorsStartN);

        final long countComradesStartN = comrades.stream()
                .filter(startsWithN)
                .count();
        Assert.assertEquals(1, countComradesStartN);
    }

    @Test
    public void testDeduplication02() {
        final long countFriendsStartN = friends.stream()
                .filter(checkIfStartsWith("N")).count();
        Assert.assertEquals(2, countFriendsStartN);

        final long countFriendsStartB = friends.stream()
                .filter(checkIfStartsWith("B")).count();
        Assert.assertEquals(1, countFriendsStartB);
    }

    @Test
    public void testDeduplication03() {
        final Function<String, Predicate<String>> startsWithLetter =
                letter -> name -> name.startsWith(letter);

        final long countFriendsStartN = friends.stream()
                .filter(startsWithLetter.apply("N")).count();
        Assert.assertEquals(2, countFriendsStartN);

        final long countFriendsStartB = friends.stream()
                .filter(startsWithLetter.apply("B")).count();
        Assert.assertEquals(1, countFriendsStartB);
    }
}