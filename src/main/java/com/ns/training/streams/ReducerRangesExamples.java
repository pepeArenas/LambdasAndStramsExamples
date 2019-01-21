package com.ns.training.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReducerRangesExamples {
    public static void main(String[] args) {
        List<Person> family = new ArrayList<>();

        Person jesus = new Person(34, "Jesus");
        Person miguelMondragon = new Person(44, "Miguel Mondragon");
        Person guadalupe = new Person(35, "Guadalupe");
        Person lupita = new Person(28, "Lupita Martinez");
        Person miguelArenas = new Person(65, "Miguel Arenas");
        Person elenita = new Person(67, "Elenita");

        family = Arrays.asList(jesus, miguelMondragon, guadalupe, lupita, miguelArenas, elenita);

        family
                .stream()
                .skip(1)
                .limit(3)
                .filter(person -> person.getEdad() < 40)
                .forEach(System.out::println);

    }

}
