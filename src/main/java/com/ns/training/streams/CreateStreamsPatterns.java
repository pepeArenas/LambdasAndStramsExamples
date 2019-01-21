package com.ns.training.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamsPatterns {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4);

        Stream<Integer> streamsSimpleWay = integers.stream();
        streamsSimpleWay.forEach(System.out::println);
        System.out.println();

        Stream<Integer> streamWithItsStaticMethod = Stream.of(0, 1, 2, 3, 4);
        streamWithItsStaticMethod.forEach(System.out::println);
        System.out.println();

        Stream<String> streamWithTheSameValueForever = Stream.generate(() -> "one");
        System.out.println("This will generate an infinite stream with the value one for all the time, so we can" +
                "limit to 5 for example");
        streamWithTheSameValueForever
                .limit(5)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Is similar to Stream.generate but that method is just a single value and cannot change" +
                "in the case of iterate we can change the value and is accumulative, in this case will print" +
                "+ the first time then +- the next time and so on, as we are limiting a 5 iteration is going to end " +
                "with +---- otherwise would print infinite");
        Stream<String> infinitePlus = Stream.iterate("+", s -> s + "-");
        infinitePlus
                .limit(5)
                .forEach(System.out::println);

        IntStream randomIntsPrimitiveValues = ThreadLocalRandom.current().ints();
        System.out.println("Will print random primitives int values");
        randomIntsPrimitiveValues
                .limit(5)
                .forEach(System.out::println);

        DoubleStream randomDoublePrimitiveValues = ThreadLocalRandom.current().doubles();
        System.out.println("Will print random doubles primitive values");
        randomDoublePrimitiveValues
                .limit(5)
                .forEach(System.out::println);

    }
}
