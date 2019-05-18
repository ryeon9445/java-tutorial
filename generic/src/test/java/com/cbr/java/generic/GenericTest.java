package com.cbr.java.generic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest {

    @Test
    public void testGeneric() {
        SchoolList<School> schools = new SchoolList<>();

        schools.add(new School());
        schools.add(new MiddleSchool());
        schools.add(new HighSchool());
//        schools.add(new Academy());   // error

        List<String> names = Arrays.asList("school", "MiddleSchool", "HighSchool");
        for (int i = 0; i < schools.size(); i++) {
            Assert.assertEquals(names.get(i), schools.get(i).name());
        }
    }

    class SchoolList<T> {

        ArrayList<T> schools = new ArrayList<>();

        void add(T school) {
            schools.add(school);
        }

        T get(int index) {
            return schools.get(index);
        }

        boolean remove(T school) {
            return schools.remove(school);
        }

        int size() {
            return schools.size();
        }
    }

    class School {

        public String name() {
            return "school";
        }
    }

    class MiddleSchool extends School {

        @Override
        public String name() {
            return "MiddleSchool";
        }
    }

    class HighSchool extends School {

        @Override
        public String name() {
            return "HighSchool";
        }
    }

    class Academy {

        public String name() {
            return "Academy";
        }
    }
}