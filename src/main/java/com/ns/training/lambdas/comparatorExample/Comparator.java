package com.ns.training.lambdas.comparatorExample;


import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1, T t2);

    /*
     * We can go a step further by parametrized the type of the comparator as following and we now can accept
     * every type and not just of type Person
     * */
    static <U> Comparator<U> comparing(Function<U, Comparable> function) {
        return (person1, person2) -> function.apply(person1).compareTo(function.apply(person2));
    }

    default Comparator<T> thenComparing(Comparator<T> comparator) {
        /*
         *If the comparator is 0 means that is equal age, then we are going to compare with the
         * other comparator that is by firstname, otherwise will continue to comparing by age
         */

        return (p1, p2) -> comparator.compare(p1, p2) == 0
                ? comparator.compare(p1, p2)
                : compare(p1, p2);
    }

    default Comparator<T> thenComparing(Function<T, Comparable> function) {
        /*
         *If the comparator is 0 means that is equal age, then we are going to compare with the
         * other comparator that is by firstname, otherwise will continue to comparing by age
         */

        return thenComparing(comparing(function));
    }


    /*
    REFACTOR TWO--- This will replace the tied implementation of Function<Person, Integer>(See OLD) and we going to receive a comparator
    the int value of the previous example will be autoboxed to a Integer, with implements the comparable interface
    already

    static Comparator<Person> comparing(Function<Person, Comparable> function) {
        return (person1, person2) -> function.apply(person1).compareTo(function.apply(person2));
    }

    REFACTOR ONE---static Comparator<Person> comparing(Function<Person, Integer> functionByAge) {
        return (person1, person2) -> functionByAge.apply(person1) - functionByAge.apply(person2);
    }*/

}
