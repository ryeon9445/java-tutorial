package com.cbr.java.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void testForEach() {
        final ArrayList<Integer> integers = new ArrayList<>();
        integers.add(4);
        integers.add(2);
        integers.add(3);
        integers.add(1);

        Stream<Integer> stream = integers.stream();
        stream.forEach(System.out::println);
    }

    @Test
    public void testForEach02() {
        String[] strings = new String[]{"four", "two", "three", "one"};

        Stream<String> stream1 = Arrays.stream(strings);
        stream1.forEach(string -> System.out.print(string + " "));
        System.out.println();

        Stream<String> stream2 = Arrays.stream(strings, 1, 3);
        stream2.forEach(string -> System.out.println(string + " "));
    }

    @Test
    public void testForEach03() {
        Stream<Double> stream = Stream.of(4.2, 2.5, 3.1, 1.9);
        stream.forEach(System.out::println);
    }

    @Test
    public void testForEach04() {
        IntStream stream1 = IntStream.range(1, 4);
        stream1.forEach(integer -> System.out.println(integer + " "));
        System.out.println();

        IntStream stream2 = IntStream.rangeClosed(1, 4);
        stream2.forEach(integer -> System.out.println(integer + " "));
    }

    @Test
    public void testForEach05() {
        IntStream stream = new Random().ints(4);
        stream.forEach(System.out::println);
    }

    @Test
    public void testEmpty() {
        Stream<Object> stream = Stream.empty();
        Assert.assertEquals(0, stream.count());
    }

    @Test
    public void testFilter() {
        IntStream stream1 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        stream1.distinct().forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        IntStream stream2 = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        stream2.filter(n -> n % 2 != 0).forEach(integer -> System.out.print(integer + " "));
    }

    @Test
    public void testMap() {
        Stream<String> stream = Stream.of("HTML", "CSS" , "JAVA", "JAVASCRIPT");
        stream.map(String::length).forEach(System.out::println);
    }

    @Test
    public void testFlatMap() {
        String[] arr = {"I study hard", "You study JAVA", "I am hungry"};

        Stream<String> stream = Arrays.stream(arr);
        stream.flatMap(s -> Stream.of(s.split(" +"))).forEach(System.out::println);
    }

    @Test
    public void testRange() {
        IntStream stream1 = IntStream.range(0, 10);
        IntStream stream2 = IntStream.range(0, 10);
        IntStream stream3 = IntStream.range(0, 10);

        stream1.skip(4).forEach(n -> System.out.print(n + " "));
        System.out.println();

        stream2.limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        stream3.skip(3).limit(5).forEach(n -> System.out.print(n + " "));
    }

    @Test
    public void testSort() {
        Stream<String> stream1 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
        Stream<String> stream2 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");

        stream1.sorted().forEach(s -> System.out.print(s + " "));
        System.out.println();

        stream2.sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));
    }

    @Test
    public void testPeek() {
        IntStream stream = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

        stream.peek(System.out::println)
                .skip(2)
                .peek(System.out::println)
                .limit(5)
                .peek(System.out::println)
                .sorted()
                .peek(System.out::println)
                .forEach(System.out::println);

    }

    @Test
    public void testReduce() {
        Stream<String> stream1 = Stream.of("four", "two", "three", "one");
        Stream<String> stream2 = Stream.of("four", "two", "three", "one");

        Optional<String> result1 = stream1.reduce((s1, s2) -> s1 + "++" + s2);
        result1.ifPresent(System.out::println);

        String result2 = stream2.reduce("start", (s1, s2) -> s1 + "++" + s2);
        System.out.println(result2);
    }

    @Test
    public void testFind() {
        IntStream stream1 = IntStream.of(4, 2, 7, 3, 5, 1, 6);
        IntStream stream2 = IntStream.of(4, 2, 7, 3, 5, 1, 6);

        OptionalInt result1 = stream1.sorted().findFirst();
        Assert.assertEquals(1, result1.getAsInt());

        OptionalInt result2 = stream2.sorted().findAny();
        Assert.assertEquals(1, result2.getAsInt());
    }

    @Test
    public void testMatch() {
        IntStream stream1 = IntStream.of(30, 90, 70, 10);
        IntStream stream2 = IntStream.of(30, 90, 70, 10);

        Assert.assertTrue(stream1.anyMatch(n -> n > 80));
        Assert.assertFalse(stream2.allMatch(n -> n > 80));
    }

    @Test
    public void testCount() {
        IntStream stream1 = IntStream.of(30, 90, 70, 10);
        IntStream stream2 = IntStream.of(30, 90, 70, 10);

        Assert.assertEquals(4, stream1.count());
        Assert.assertEquals(90, stream2.max().getAsInt());
    }

    @Test
    public void testSum() {
        IntStream stream1 = IntStream.of(30, 90, 70, 10);
        DoubleStream stream2 = DoubleStream.of(30.3, 90.9, 70.7, 10.1);

        Assert.assertEquals(200, stream1.sum());
        Assert.assertEquals(50.5f, stream2.average().getAsDouble(), 0);
    }

    @Test
    public void testCollect() {
        Stream<String> stream = Stream.of("four", "two", "one", "three");

        List<String> list = stream.collect(Collectors.toList());
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next() + " ");
        }
    }

    @Test
    public void testPartitioningBy() {
        Stream<String> stream = Stream.of("HTML", "CSS", "JAVA", "PHP");

        Map<Boolean, List<String>> patition =
                stream.collect(Collectors.partitioningBy(s -> (s.length() % 2) == 0));

        List<String> oddLengthList = patition.get(false);
        System.out.println(oddLengthList);

        List<String> evenLengthList = patition.get(true);
        System.out.println(evenLengthList);
    }

    @Test
    public void testOptional() {
        Optional<String> opt = Optional.ofNullable("Java Optional Object");
        System.out.println(opt.get());
    }

    @Test
    public void testOptional2() {
        Optional<String> opt = Optional.ofNullable("Java Optional Object");

        if (opt.isPresent()) {
            System.out.println(opt.get());
        }
    }

    @Test
    public void testOptional3() {
        Optional<String> opt = Optional.empty();
        System.out.println(opt.orElse("empty optional object"));
        System.out.println(opt.orElseGet(String::new));
    }

    @Test
    public void testOptional4() {
        IntStream stream = IntStream.of(4, 2, 1, 3);
        OptionalInt result = stream.findFirst();

        System.out.println(result.getAsInt());
    }
}