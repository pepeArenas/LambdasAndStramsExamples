package com.ns.training.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LamdaWithMethodReferece {

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        List<Integer> numerosVacios = new ArrayList<>();

        Consumer<Integer> consumer = System.out::println;
        Consumer<Integer> consumer1 = numerosVacios::add;

        //The important thing is that we can now chain lambdas, specifically consumers in this example
        numeros.forEach(consumer.andThen(consumer1));

        numerosVacios.forEach(System.out::println);

    }
}
