package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.Stream;

public class RecursionTest {

    @Test(expected = StackOverflowError.class)
    public void testRecursion1() {
        System.out.println(Factorial.factorialRec(20000));
    }

    @Test
    public void testRecursion2() {
        Assert.assertEquals(0, Factorial.factorialTailRec(1, 20000).invoke().intValue());
    }

    @Test
    public void testRecursion3() {
        Assert.assertEquals(120, BigFactorial.factorial(BigFactorial.FIVE).intValue());
        Assert.assertEquals("1819206320...",
                String.format("%.10s...", BigFactorial.factorial(BigFactorial.TWENTYK)));
    }

    private static class Factorial {

        public static int factorialRec(final int number) {
            if (number == 1) {
                return number;
            } else {
                return number * factorialRec(number - 1);
            }
        }

        public static TailCall<Integer> factorialTailRec(final int factorial, final int number) {
            if (number == 1) {
                return TailCalls.done(factorial);
            } else {
                return TailCalls.call(() -> factorialTailRec(factorial * number, number - 1));
            }
        }
    }

    @FunctionalInterface
    private interface TailCall<T> {

        TailCall<T> apply();

        default boolean isComplete() {
            return false;
        }

        default T result() {
            throw new Error("not implemented");
        }

        default T invoke() {
            return Stream.iterate(this, TailCall::apply)
                    .filter(TailCall::isComplete)
                    .findFirst()
                    .get()
                    .result();
        }
    }

    private static class TailCalls {

        public static <T> TailCall<T> call(final TailCall<T> nextCall) {
            return nextCall;
        }

        public static <T> TailCall<T> done(final T value) {
            return new TailCall<T>() {

                @Override
                public boolean isComplete() {
                    return true;
                }

                @Override
                public T result() {
                    return value;
                }

                @Override
                public TailCall<T> apply() {
                    throw new Error("not implemented");
                }
            };
        }
    }

    private static class BigFactorial {

        final static BigInteger ONE = BigInteger.ONE;
        final static BigInteger FIVE = new BigInteger("5");
        final static BigInteger TWENTYK = new BigInteger("20000");

        public static BigInteger decrement(final BigInteger number) {
            return number.subtract(BigInteger.ONE);
        }

        public static BigInteger multiply(final BigInteger first, final BigInteger second) {
            return first.multiply(second);
        }

        public static TailCall<BigInteger> factorialTailRec(final BigInteger factorial, final BigInteger number) {
            if (number.equals(BigInteger.ONE)) {
                return TailCalls.done(factorial);
            } else {
                return TailCalls.call(() -> factorialTailRec(multiply(factorial, number), decrement(number)));
            }
        }

        public static BigInteger factorial(final BigInteger number) {
            return factorialTailRec(BigInteger.ONE, number).invoke();
        }
    }
}