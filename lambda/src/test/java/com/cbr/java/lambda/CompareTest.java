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
        List<Data.Person> ascendingAge = Data.PEOPLE.stream()
                .sorted(Data.Person::ageDifference)
                .collect(Collectors.toList());

        Assert.assertEquals(20, ascendingAge.stream().findFirst().orElseGet(Data.Person::new).getAge());
        System.out.println(ascendingAge);
    }

    @Test
    public void testCompare02() {
        Comparator<Data.Person> ascendingAgeComparator = Data.Person::ageDifference;
        Comparator<Data.Person> descendingAgeComparator = ascendingAgeComparator.reversed();
        List<Data.Person> descendingAge = Data.PEOPLE.stream()
                .sorted(descendingAgeComparator)
                .collect(Collectors.toList());

        Assert.assertEquals(35, descendingAge.stream().findFirst().orElseGet(Data.Person::new).getAge());
        System.out.println(descendingAge);
    }

    @Test
    public void testCompare03() {
        Data.PEOPLE.stream()
                .min(Data.Person::ageDifference)
                .ifPresent(youngest -> Assert.assertEquals(20, youngest.getAge()));

        Data.PEOPLE.stream()
                .max(Data.Person::ageDifference)
                .ifPresent(eldest -> Assert.assertEquals(35, eldest.getAge()));
    }

    @Test
    public void testCompare04() {
        List<Data.Person> ascendingName = Data.PEOPLE.stream()
                .sorted(Comparator.comparing(Data.Person::getName))
                .collect(Collectors.toList());

        Assert.assertEquals("Greg", ascendingName.stream().findFirst().orElseGet(Data.Person::new).getName());

        ascendingName = Data.PEOPLE.stream()
                .sorted(Comparator.comparing(Data.Person::getName).reversed())
                .collect(Collectors.toList());

        Assert.assertEquals("Sara", ascendingName.stream().findFirst().orElseGet(Data.Person::new).getName());
    }

    @Test
    public void testCompare05() {
        final Function<Data.Person, Integer> byAge = Data.Person::getAge;
        final Function<Data.Person, String> byTheirName = Data.Person::getName;

        List<Data.Person> sortedPersons = Data.PEOPLE.stream()
                .sorted(Comparator.comparing(byAge).thenComparing(byTheirName))
                .collect(Collectors.toList());

        System.out.println(sortedPersons);
        Assert.assertEquals("Jane", sortedPersons.get(1).getName());
    }
}