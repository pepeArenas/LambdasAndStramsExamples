package com.ns.training.newtocollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsFeaturesMain {
    public static void main(String[] args) {
        List<Person> family = new ArrayList<>();

        Person jesus = new Person("Jesus", 34);
        Person miguelMondragon = new Person("Miguel Mondragon", 44);
        Person guadalupe = new Person("Guadalupe", 36);
        Person elenita = new Person("Elenita", 67);
        Person miguelArenas = new Person("Miguel Arenas", 64);
        Person frodo = new Person("Frodo", 14);

        family.addAll(Arrays.asList(jesus, miguelArenas, miguelMondragon, guadalupe, elenita));

        System.out.println("First hash code of the list: " + family.hashCode());

        System.out.println("Before remove");
        family.forEach(System.out::println);
        System.out.println("Is the same hashcode because so far just iterarte over the list " + family.hashCode());

        family.removeIf(person -> person.getAge() < 40);
        System.out.println("After remove");
        family.forEach(System.out::println);
        System.out.println("We remove some elements and the hashcode is a new one: " + family.hashCode());

        family.replaceAll(person -> new Person(
                person.getName().toUpperCase(),
                person.getAge()));
        System.out.println("After to uppercase");
        family.forEach(System.out::println);
        System.out.println("And we change again the list by uppercased all the names so is another hashcode: "
                + family.hashCode());

        family.sort(Comparator.comparing(Person::getAge));
        family.forEach(System.out::println);
        System.out.println("Again we change the order so is need to be another hashcode:" + family.hashCode());

        family.sort(Comparator.comparing(Person::getAge).reversed());
        family.forEach(System.out::println);
        System.out.println("And again it must be another hashcode because we are modify the order " + family.hashCode());

        List<City> cities = new ArrayList<>();

        City cdmx = new City("CDMX");
        City estadoDeMexico = new City("Estado de Mexico");

        Collections.addAll(Arrays.asList(cdmx, estadoDeMexico));

        Map<City, List<Person>> habitants1 = new HashMap<>();

        System.out.println("Clasical get on map " + habitants1.get(cdmx));

        System.out.println("putIfAbsent receive two parameter, the first is the key " +
                "and the second is the will initialize the key with a default value which is specified " +
                "if the key is absent, once the key is in the map we can add a list of persons");
        habitants1.putIfAbsent(cdmx, new ArrayList<>());
        System.out.println("once the key is in the map we can add a list of persons");
        habitants1.get(cdmx).add(guadalupe);

        System.out.println("This also can be achieved with a computeIfAbsent and all the logic is encapsulates");
        /*
         *The first parameter is the key that we want to add and the second is a lambda, as it will return if
         * absent a new array list( otherwise is not execute the lambda) we can chain the add of the specific
         * person in the same line
         */
        habitants1.computeIfAbsent(estadoDeMexico, city -> new ArrayList<>()).add(elenita);
        /*
         *We can add the same line of before to add a new person, but as the array already contains an element
         * the lambda will not execute anymore
         */
        habitants1.computeIfAbsent(estadoDeMexico, city -> new ArrayList<>()).add(miguelArenas);

        System.out.println("People from CDMX " + habitants1.getOrDefault(cdmx, Collections.EMPTY_LIST));
        System.out.println("People from Mexico State " + habitants1.getOrDefault(estadoDeMexico, Collections.EMPTY_LIST));

        System.out.println();

        System.out.println("habitants1");
        habitants1.forEach(((city, people) -> System.out.println(city + " : " + people)));

        Map<City, List<Person>> habitants2 = new HashMap<>();
        habitants2.computeIfAbsent(estadoDeMexico, city -> new ArrayList<>()).add(frodo);
        habitants2.computeIfAbsent(cdmx, city -> new ArrayList<>()).add(jesus);
        habitants2.computeIfAbsent(cdmx, city -> new ArrayList<>()).add(miguelMondragon);

        System.out.println("habitants2");
        habitants2.forEach(((city, people) -> System.out.println(city + " : " + people)));

        /*
        Example with merge, we have two maps habitant1 and habitant2, and we want to merge map2 into map1
         */
        habitants2.forEach(
                (city, people) -> {
                    habitants1.merge(
                            city, people,
                            (peopleFromMap1, peopleFromMap2) -> {
                                peopleFromMap1.addAll(peopleFromMap2);
                                return peopleFromMap1;
                            });
                }
        );
        System.out.println();
        System.out.println("Merged ");
        habitants1.forEach(((city, people) -> System.out.println(city + " : " + people)));

    }
}
