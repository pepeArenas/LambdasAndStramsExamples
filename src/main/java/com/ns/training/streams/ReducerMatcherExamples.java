package com.ns.training.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReducerMatcherExamples {
    public static void main(String[] args) {
        List<Person> family = new ArrayList<>();

        Person jesus = new Person(34, "Jesus");
        Person miguelMondragon = new Person(44, "Miguel Mondragon");
        Person guadalupe = new Person(35, "Guadalupe");
        Person lupita = new Person(28, "Lupita Martinez");
        Person miguelArenas = new Person(65, "Miguel Arenas");
        Person elenita = new Person(67, "Elenita");

        family = Arrays.asList(jesus, miguelMondragon, guadalupe, lupita, miguelArenas, elenita);

        boolean anyMemberOnTheListContainsAWhitespace = family
                .stream()
                .anyMatch(person -> person.getName().contains(" "));
        System.out.println("Any element contains a whitespace " + anyMemberOnTheListContainsAWhitespace);

        boolean allMembersOnTheListHasAWhitespace = family
                .stream()
                .allMatch(person -> person.getName().contains(" "));
        System.out.println("All the elements in the list has a whitespace, should be false "
                + allMembersOnTheListHasAWhitespace);

        boolean noneOfTheMembersAreOldestThanSeventy = family
                .stream()
                .noneMatch(person -> person.getEdad() > 70);
        System.out.println("None of the member is older than 70 " + noneOfTheMembersAreOldestThanSeventy);
    }
}
