package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompareTest {

    private final List<Person> people = Arrays.asList(
            new Person("Greg", 35),
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21));

    @Test
    public void testCompare01() {
        List<Person> ascendingAge = people.stream()
                .sorted(Person::ageDifference)
                .collect(Collectors.toList());

        Assert.assertEquals(20, ascendingAge.stream().findFirst().orElseGet(Person::new).age);
        System.out.println(ascendingAge);
    }

    @Test
    public void testCompare02() {
        Comparator<Person> ascendingAgeComparator = Person::ageDifference;
        Comparator<Person> descendingAgeComparator = ascendingAgeComparator.reversed();
        List<Person> descendingAge = people.stream()
                .sorted(descendingAgeComparator)
                .collect(Collectors.toList());

        Assert.assertEquals(35, descendingAge.stream().findFirst().orElseGet(Person::new).age);
        System.out.println(descendingAge);
    }

    @Test
    public void testCompare03() {
        people.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> Assert.assertEquals(20, youngest.getAge()));

        people.stream()
                .max(Person::ageDifference)
                .ifPresent(eldest -> Assert.assertEquals(35, eldest.getAge()));
    }

    @Test
    public void testCompare04() {
        List<Person> ascendingName = people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());

        Assert.assertEquals("Greg", ascendingName.stream().findFirst().orElseGet(Person::new).getName());

        ascendingName = people.stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .collect(Collectors.toList());

        Assert.assertEquals("Sara", ascendingName.stream().findFirst().orElseGet(Person::new).getName());
    }

    @Test
    public void testCompare05() {
        final Function<Person, Integer> byAge = Person::getAge;
        final Function<Person, String> byTheirName = Person::getName;

        List<Person> sortedPersons = people.stream()
                .sorted(Comparator.comparing(byAge).thenComparing(byTheirName))
                .collect(Collectors.toList());

        System.out.println(sortedPersons);
        Assert.assertEquals("Jane", sortedPersons.get(1).getName());
    }

    public class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person() {
            name = "";
            age = 0;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int ageDifference(final Person other) {
            return age - other.age;
        }

        public String toString() {
            return String.format("%s - %d", name, age);
        }
    }
}