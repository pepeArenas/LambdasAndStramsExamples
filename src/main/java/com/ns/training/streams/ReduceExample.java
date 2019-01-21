package com.ns.training.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {

        List<Person> personas = new ArrayList<>();
        personas.add(new Person(33, "Jesus"));
        personas.add(new Person(33, "Jose"));
        personas.add(new Person(44, "Miguel Chico"));
        personas.add(new Person(64, "Miguel Arenas"));
        personas.add(new Person(35, "Guadalupe"));
        personas.add(new Person(67, "Maria Elena"));


        /*
        Corner cases:
        1 Si la lista esta vacia la suma sera el elemento identificados
        2 Si la lista tiene un elemento la suma sera la identidad mas el elemento
        * */
        Integer sumatoriaEdades = personas
                .stream()
                .map(person -> person.getEdad())
                .reduce(0, Integer::sum);


        System.out.println("Sumatoria de edades " + sumatoriaEdades);

        Optional<Integer> min = personas
                .stream()
                .map(person -> person.getEdad())
                .filter(edad -> edad < 50)
                .min(Comparator.naturalOrder());

        System.out.println("Edad minina " + min);


        List<Integer> list;
        //Si ponemos el array vacio nos regresa un opcional vacio
        list = Arrays.asList();
        //Max se comporta diferente, no podemos usar el identificador, tenemos que usar optionals
        Optional<Integer> maximo = list.stream().reduce(Integer::max);
        System.out.println("Maximo con lista vacia " + maximo);
        list = Arrays.asList(-10);
        maximo = list.stream().reduce(Integer::max);
        System.out.println("Maximo con array no empty valores negativos " + maximo);
        //Con mas valores positivos en la lista
        list = Arrays.asList(1, 2, 3);
        maximo = list.stream().reduce(Integer::max);
        System.out.println("Maximo con array no empty valores positivos " + maximo);
        //Con mas valores en la lista
        list = Arrays.asList(0, -10);
        maximo = list.stream().reduce(Integer::max);
        System.out.println("Maximo con array no empty valores positivos y negativos " + maximo);



    }
}
