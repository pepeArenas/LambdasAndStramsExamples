package com.ns.training.lambdas.predicateExample;

public class MainPredicate {

    public static void main(String[] args) {
        Predicate<String> max = string -> string.length() < 40;
        Predicate<String> min = string -> string.length() > 5;

        System.out.println("Jesus should be false " + max.test("Jesus"));
        System.out.println("Jose de Jesus Arenas Mondragon should be true " +
                max.test("Jose de Jesus Arenas Mondragon"));

        Predicate<String> p1 = max.and(min);
        System.out.println("Jesus should be false " + p1.test("jesu"));
        System.out.println("Jose de Jesus Arenas Mondragon should be true xx"
                + p1.test("Jose de Jesus Arenas Mondragon"));

        Predicate<String> p2 = max.or(min);

        System.out.println("Jesus should be true " + p2.test("jesus"));
        System.out.println("Jose de Jesus Arenas Mondragon should be true "
                + p2.test("Jose de Jesus Arenas Mondragon"));

        Predicate<String> p3 =  Predicate.isEqualsTo("Jesus");

        System.out.println();
        System.out.println(p3.test("Jesus"));
        System.out.println(p3 .test("Jose"));

    }

}
