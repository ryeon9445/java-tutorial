package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
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

    @Test
    public void testCollect04() {
        List<Data.Person> olderThan20 = Data.PEOPLE.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.toList());
        Assert.assertEquals(3, olderThan20.size());
    }

    @Test
    public void testCollect05() {
        Map<Integer, List<Data.Person>> peopleByAge = Data.PEOPLE.stream()
                .collect(Collectors.groupingBy(Data.Person::getAge));
        System.out.println(peopleByAge);
        Assert.assertEquals(3, peopleByAge.size());
    }

    @Test
    public void testCollect06() {
        Map<Integer, List<String>> nameOfPeopleByAge = Data.PEOPLE.stream()
                .collect(Collectors.groupingBy(Data.Person::getAge,
                        Collectors.mapping(Data.Person::getName, Collectors.toList())));
        Assert.assertEquals(3, nameOfPeopleByAge.size());
        System.out.println(nameOfPeopleByAge);
    }

    @Test
    public void testCollect07() {
        Comparator<Data.Person> byAge = Comparator.comparing(Data.Person::getAge);
        Map<Character, Optional<Data.Person>> oldestPersonOfEachLetter = Data.PEOPLE.stream()
                .collect(Collectors.groupingBy(person -> person.getName().charAt(0),
                        Collectors.reducing(BinaryOperator.maxBy(byAge))));

        Assert.assertEquals(3, oldestPersonOfEachLetter.size());
        System.out.println(oldestPersonOfEachLetter);
    }
}