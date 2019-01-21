package com.ns.training.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DifferenceBetweenIntermetiateAndFinalOp {

    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Jesus");
        nombres.add("Jose");
        nombres.add("Guadalupe");
        nombres.add("Miguel Chico");
        nombres.add("Miguel Arenas");
        nombres.add("Maria Elena");

        Predicate<String> filterByLength = s -> s.length() >= 10;
        Predicate<String> filteredByJ = s -> s.startsWith("M");

        List<String> filteredNames = new ArrayList<>();

        //If we code like this is not going to do anything because we are not finalize or stream, we need to finalize
        // with a final operator and not an intermediate, the difference between a intermediate and a final operator
        // is the return type, if return a stream is an intermediate and if return void is a final and it will
        // trigger the stream behavior
        nombres.stream()
                .peek(System.out::println)
                .filter(filterByLength.and(filteredByJ))
                .peek(filteredNames::add);

        System.out.println("Done");
        System.out.println("The size of filtered names are: " + filteredNames.size());

        //If we want that code works we need to finalize with a finalizer method such forEach instead of a intermediate
        // method such peak
        nombres.stream()
                .peek(System.out::println)
                .filter(filterByLength.and(filteredByJ))
                .forEach(filteredNames::add);

        System.out.println("Done with a finalizer method");
        System.out.println("The size of filtered names are: " + filteredNames.size());

    }
}
