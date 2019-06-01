package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class CollectTest {

    @Test
    public void testCollect() {
        String collect = Constants.FRIENDS.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println(collect);
    }

    @Test
    public void testCollect02() {
        List<Person> olderThan20 = new ArrayList<>();
        Constants.PEOPLE.stream()
                .filter(person -> person.getAge() > 20)
                .forEach(olderThan20::add);

        Assert.assertEquals(3, olderThan20.size());
    }

    @Test
    public void testCollect03() {
        List<Person> olderThan20 = Constants.PEOPLE.stream()
                .filter(person -> person.getAge() > 20)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        Assert.assertEquals(3, olderThan20.size());
    }

    @Test
    public void testCollect04() {
        List<Person> olderThan20 = Constants.PEOPLE.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.toList());
        Assert.assertEquals(3, olderThan20.size());
    }

    @Test
    public void testCollect05() {
        Map<Integer, List<Person>> peopleByAge = Constants.PEOPLE.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(peopleByAge);
        Assert.assertEquals(3, peopleByAge.size());
    }

    @Test
    public void testCollect06() {
        Map<Integer, List<String>> nameOfPeopleByAge = Constants.PEOPLE.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.toList())));
        Assert.assertEquals(3, nameOfPeopleByAge.size());
        System.out.println(nameOfPeopleByAge);
    }

    @Test
    public void testCollect07() {
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        Map<Character, Optional<Person>> oldestPersonOfEachLetter = Constants.PEOPLE.stream()
                .collect(Collectors.groupingBy(person -> person.getName().charAt(0),
                        Collectors.reducing(BinaryOperator.maxBy(byAge))));

        Assert.assertEquals(3, oldestPersonOfEachLetter.size());
        System.out.println(oldestPersonOfEachLetter);
    }
}