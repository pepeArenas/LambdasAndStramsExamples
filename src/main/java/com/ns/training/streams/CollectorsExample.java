package com.ns.training.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsExample {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person(33, "Jesus"));
        persons.add(new Person(33, "Jose"));
        persons.add(new Person(44, "Miguel Mondragon"));
        persons.add(new Person(35, "Guadalupe Mondragon"));
        persons.add(new Person(64, "Miguel Arenas"));
        persons.add(new Person(66, "Maria Elena"));

        Map<Integer, List<Person>> ages = persons
                .stream()
                .collect(
                        Collectors.groupingBy(Person::getEdad)
                );

        System.out.println(ages);

        //With post procesing downstream
        Map<Integer, Long> map = persons
                .stream()
                .collect(
                        Collectors.groupingBy(Person::getEdad,
                                Collectors.counting()
                        )
                );

        System.out.println("With downstream " + map);

        //With post procesing y queremos en lugar del numero de repeticiones, los nombres de estos
        Map<Integer, List<String>> mapNombres = persons
                .stream()
                .collect(
                        Collectors.groupingBy(Person::getEdad,
                                Collectors.mapping(
                                        Person::getName,
                                        Collectors.toList()
                                )
                        )
                );

        System.out.println("With downstream nombres" + mapNombres);

    }
}
