package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompareTest {

    @Test
    public void testCompare01() {
        List<Person> ascendingAge = Constants.PEOPLE.stream()
                .sorted(Person::ageDifference)
                .collect(Collectors.toList());

        Assert.assertEquals(20, ascendingAge.stream().findFirst().orElseGet(Person::new).getAge());
        System.out.println(ascendingAge);
    }

    @Test
    public void testCompare02() {
        Comparator<Person> ascendingAgeComparator = Person::ageDifference;
        Comparator<Person> descendingAgeComparator = ascendingAgeComparator.reversed();
        List<Person> descendingAge = Constants.PEOPLE.stream()
                .sorted(descendingAgeComparator)
                .collect(Collectors.toList());

        Assert.assertEquals(35, descendingAge.stream().findFirst().orElseGet(Person::new).getAge());
        System.out.println(descendingAge);
    }

    @Test
    public void testCompare03() {
        Constants.PEOPLE.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> Assert.assertEquals(20, youngest.getAge()));

        Constants.PEOPLE.stream()
                .max(Person::ageDifference)
                .ifPresent(eldest -> Assert.assertEquals(35, eldest.getAge()));
    }

    @Test
    public void testCompare04() {
        List<Person> ascendingName = Constants.PEOPLE.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        Assert.assertEquals("Greg", ascendingName.stream().findFirst().orElseGet(Person::new).getName());

        ascendingName = Constants.PEOPLE.stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .collect(Collectors.toList());

        Assert.assertEquals("Sara", ascendingName.stream().findFirst().orElseGet(Person::new).getName());
    }

    @Test
    public void testCompare05() {
        final Function<Person, Integer> byAge = Person::getAge;
        final Function<Person, String> byTheirName = Person::getName;

        List<Person> sortedPersons = Constants.PEOPLE.stream()
                .sorted(Comparator.comparing(byAge).thenComparing(byTheirName))
                .collect(Collectors.toList());

        System.out.println(sortedPersons);
        Assert.assertEquals("Jane", sortedPersons.get(1).getName());
    }
}