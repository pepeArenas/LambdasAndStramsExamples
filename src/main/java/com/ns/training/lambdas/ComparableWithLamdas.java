package com.ns.training.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableWithLamdas {
    public static void main(String[] args) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        List<String> list = Arrays.asList("***", "**", "****", "*");
        Collections.sort(list, comparator);

        for (String asterix : list
        ) {
            System.out.println(asterix);
        }

        Comparator<String> comparatorWithLambdas = (String o1, String o2) ->
                Integer.compare(o1.length(), o2.length());

        Collections.sort(list, comparatorWithLambdas);

        for (String asterix : list
        ) {
            System.out.println(asterix);
        }

    }
}
