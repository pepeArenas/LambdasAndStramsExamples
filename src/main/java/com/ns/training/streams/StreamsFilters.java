package com.ns.training.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StreamsFilters {

    public static void main(String[] args) {
        List<String> nombres = new ArrayList();

        nombres.add("Jesus");
        nombres.add("Guadalupe");
        nombres.add("Jose");
        nombres.add("Miguel Chico");
        nombres.add("Miguel Arenas");
        nombres.add("Maria Elena");

        Predicate<String> filterByLength = s -> s.length() < 10;
        Predicate<String> filterByStartingWithFirstLetter = s -> s.startsWith("J");
        Predicate<String> filterByStartingWithFirstTwoLetters = s -> s.startsWith("G");

        nombres.stream().
                filter(filterByLength.
                        and(filterByStartingWithFirstLetter.
                                or(filterByStartingWithFirstTwoLetters))).
                forEach(System.out::println);


    }
}
