package com.ns.training.streams;

import java.util.StringJoiner;

public class Person{
    private int edad;
    private String name;

    public Person(int edad, String name) {
        this.edad = edad;
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("edad=" + edad)
                .add("name='" + name + "'")
                .toString();
    }
}
