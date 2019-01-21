package com.ns.training.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class reduceFindExamples {
    public static void main(String[] args) {
        List<Person> family = new ArrayList<>();

        Person jesus = new Person(34, "Jesus");
        Person miguelMondragon = new Person(44, "Miguel Mondragon");
        Person guadalupe = new Person(35, "Guadalupe");
        Person lupita = new Person(28, "Lupita Martinez");
        Person miguelArenas = new Person(65, "Miguel Arenas");
        Person elenita = new Person(67, "Elenita");

        family = Arrays.asList(jesus, miguelMondragon, guadalupe, lupita, miguelArenas, elenita);


        Optional<Person> firstPersonWithWhitespaces = family
                .stream()
                .filter(person -> person.getName().contains(" "))
                .findFirst();
        System.out.println("The first person which name contains a whitespace is: " + firstPersonWithWhitespaces);

        List<Person> emptyList = new ArrayList<>();

        Optional<Person> firstPersonOnEmptyList = emptyList
                .stream()
                .filter(person -> person.getName().contains(" "))
                .findFirst();
        System.out.println("The first person on an empty list: " + firstPersonOnEmptyList);

        Optional<Person> anyPersonNotFulfillPredicate = family
                .stream()
                .filter(person -> person.getEdad()>79)
                .findAny();
        System.out.println("The predicate is not fulfill "  + anyPersonNotFulfillPredicate);

        Optional<Person> anyPersonFulfillPredicate = family
                .stream()
                .filter(person -> person.getEdad()>40)
                .findAny();
        System.out.println("The predicate is fulfill "  + anyPersonFulfillPredicate);


    }
}
