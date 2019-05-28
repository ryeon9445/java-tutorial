package com.cbr.java.lambda;

import java.util.Arrays;
import java.util.List;

public class Data {

    public static final List<String> FRIENDS = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    public static final List<String> EDITORS = Arrays.asList("Brian", "Jackie", "John", "Mike");
    public static final List<String> COMRADES = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

    public static final List<Person> PEOPLE = Arrays.asList(
            new Person("Greg", 35),
            new Person("John", 20),
            new Person("Sara", 21),
            new Person("Jane", 21));

    public static class Person {
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