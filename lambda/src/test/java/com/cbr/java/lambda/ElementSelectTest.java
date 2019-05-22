package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class ElementSelectTest {

    @Test
    public void testOldMethod() {
        Assert.assertNotNull(oldMethod(Data.FRIENDS, "N"));
        Assert.assertNull(oldMethod(Data.FRIENDS, "Z"));
    }

    @Test
    public void testLambdaMethod() {
        Assert.assertNotNull(lambdaMethod(Data.FRIENDS, "N"));
        Assert.assertNull(lambdaMethod(Data.FRIENDS, "Z"));
    }

    private String oldMethod(final List<String> friends, final String startingLetter) {
        String foundName = null;
        for (String name : friends) {
            if(name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }

        System.out.println(String.format("A name starting with %s: ", startingLetter));

        if (foundName != null) {
            System.out.println(foundName);
            return foundName;
        } else {
            System.out.println("No name found");
            return null;
        }
    }

    private String lambdaMethod(final List<String> friends, final String startingLetter) {
        final Optional<String> foundName = friends.stream()
                .filter(name -> name.startsWith(startingLetter))
                .findFirst();

        foundName.ifPresent(name -> System.out.println("Hello " + name));
        return foundName.orElse(null);
    }
}