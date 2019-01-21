package com.ns.training.lambdas.comparatorExample;

import java.util.function.Function;

public class MainComparator {

    public static void main(String[] args) {
        Comparator<Person> compareByAge =
                (person1, person2) ->
                        person1.getAge() - person2.getAge();
        //Since String class implements comparable interface we can compare
        Comparator<Person> compareByFirstname =
                (person1, person2) ->
                        person1.getFirstName().compareTo(person2.getFirstName());
        Comparator<Person> compareByLastname =
                (person1, person2) ->
                        person1.getLastName().compareTo(person2.getLastName());

        /*
        We have a common pattern in the previous comparators, all of them receive two parameters and return the
        comparision of its fields, so we can have a function that takes both objects and return the comparision
        * */
        Function<Person, Integer> functionByAge = Person::getAge;
        Function<Person, String> functionByFirstname = Person::getFirstName;
        Function<Person, String> functionByLastname = Person::getLastName;

        /*
        Now we want to build a Comparator which receive the function itself and compare two persons, so we need tu build
        a static method in our functional interface in where we accept a Function as a parameter
        * */

        //Comparator<Person> personComparator = Comparator.comparing(functionByAge);
        //As I can pass the lambda expression instead of a function, I can write as a method reference syntax - like
        //And this pattern is more readable
        Comparator<Person> personAgeComparator = Comparator.comparing(Person::getAge);
        /*
        By trying to do this, as our signature of comparing is (Function <Person, Integer>), in this case we need
        a generic signature that is not tied to Person, Integer, but we need to change to a person Comparable type
        in order we not to be tied to a Integer, so now we can pass all class which implements comparable such as
        String, Integer, Boolean, all wrapper classes
        */
        Comparator<Person> personFirstnameComparator = Comparator.comparing(Person::getFirstName);
        /*
        Now we can try to chain our comparator, meanwhile the comparators are of the same type, we need to write
        a method with receive a Comparator<U> and return a Comparator<U>
        * */
        //This is how we need to program our APIs
        Comparator<Person> personComparatorByAgeAndFirstname =
                Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getFirstName);


    }
}
