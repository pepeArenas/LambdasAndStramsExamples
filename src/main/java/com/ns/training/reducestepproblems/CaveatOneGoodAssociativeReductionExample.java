package com.ns.training.reducestepproblems;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class CaveatOneGoodAssociativeReductionExample {

    public static int reduce(
            List<Integer> values,
            int valueIfEmpty,
            BinaryOperator<Integer> reduction) {
        int result = valueIfEmpty;
        for (int value : values
        ) {
            result = reduction.apply(result, value);
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> ints1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(5, 6, 7, 8, 9);

        /*
        The sum is associative because we do not care about the order of the parenthesis, this is important
        because in order to be parallel safe, must fulfill the caveat of being associative, so in this case
        it will be the same result whenever is parallel or not, the same case with max operation since max
        is also a associative operation
        BinaryOperator<Integer> op = (i1, i2) -> Integer.max(i1,i2);
         */
        BinaryOperator<Integer> op = (i1, i2) -> i1 + i2;

        int reduction1 = reduce(ints1, 0, op);
        int reduction2 = reduce(ints2, 0, op);

        int reduction = reduce(ints, 0, op);
        int reductionParallelSimulation = reduce(Arrays.asList(reduction1, reduction2), 0, op);

        System.out.println("Reduction :" + reduction);
        System.out.println("Reduction parallel simulation:" + reductionParallelSimulation);

    }
}
