package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ReduceTest {

    @Test
    public void testSum() {
        int  totalOfCharactersInAllFriends= Constants.FRIENDS.stream()
                .mapToInt(String::length)
                .sum();
        Assert.assertEquals(26, totalOfCharactersInAllFriends);
    }

    @Test
    public void testReduce() {
        final Optional<String> aLongName = Constants.FRIENDS.stream()
                .reduce((friends1, friends2) ->
                        friends1.length() >= friends2.length() ? friends1 : friends2);

        aLongName.ifPresent(friend ->
                System.out.println(String.format("A longest name: %s", friend)));

        Assert.assertEquals("Brian", aLongName.orElseGet(String::new));
    }

    @Test
    public void testReduce2() {
        final String steveOrLonger = Constants.FRIENDS.stream()
                .reduce("Steve", (friend1, friend2) ->
                        friend1.length() >= friend2.length() ? friend1 : friend2);

        Assert.assertEquals("Steve", steveOrLonger);
    }
}