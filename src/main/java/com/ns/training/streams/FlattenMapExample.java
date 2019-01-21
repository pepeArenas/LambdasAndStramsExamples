package com.ns.training.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlattenMapExample {

    public static void main(String[] args) {
        List<Integer> edadesHijos = Arrays.asList(3, 4, 5);
        List<Integer> edadesPrimosPadre = Arrays.asList(2, 3, 4, 9);
        List<Integer> edadesPrimosMadre = Arrays.asList(3, 4, 7, 8, 10);

        List<List<Integer>> edades = Arrays.asList(edadesHijos, edadesPrimosPadre, edadesPrimosMadre);

        Function<List<?>, Integer> size = List::size;
        Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();

        System.out.println("Tamaño de cada lista");

        edades.stream()
                .map(size)
                .forEach(System.out::println);

        System.out.println("Edades con flat map, una todas las listas y hace una");

        edades.stream()
                .flatMap(flatMapper)
                .forEach(System.out::println);
    }
}
