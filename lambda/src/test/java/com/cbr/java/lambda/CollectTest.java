package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectTest {

    @Test
    public void testCollect() {
        String collect = Data.FRIENDS.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println(collect);
    }

    @Test
    public void testCollect02() {
        List<Data.Person> olderThan20 = new ArrayList<>();
        Data.PEOPLE.stream()
                .filter(person -> person.getAge() > 20)
                .forEach(olderThan20::add);

        Assert.assertEquals(3, olderThan20.size());
    }

    @Test
    public void testCollect03() {
        List<Data.Person> olderThan20 = Data.PEOPLE.stream()
                .filter(person -> person.getAge() > 20)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        Assert.assertEquals(3, olderThan20.size());
    }
}