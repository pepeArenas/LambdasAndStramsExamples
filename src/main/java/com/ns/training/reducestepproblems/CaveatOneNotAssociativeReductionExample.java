package com.ns.training.reducestepproblems;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class CaveatOneNotAssociativeReductionExample {
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
        List<Integer> ints3 = Arrays.asList(1, 2);
        List<Integer> ints4 = Arrays.asList(3, 4, 5, 6, 7, 8, 9);



        /*
        In this example we are sum and multiply so is not an accumulative operation because the operator are not
        the same, so it will return different results, and if we change the content of the list int1 and int2 for
        example
        List<Integer> ints1 = Arrays.asList(1,2);
        List<Integer> ints2 = Arrays.asList(3,4,5, 6, 7, 8, 9);
        it will return another result yet in a parallel way, it happen the same with:
         BinaryOperator<Integer> op = (i1, i2) -> (i1 + i2) / 2; that represent the average
         */
        BinaryOperator<Integer> op = (i1, i2) -> (i1 + i2) * (i1 + i2);

        int reduction1 = reduce(ints1, 0, op);
        int reduction2 = reduce(ints2, 0, op);
        int reduction3 = reduce(ints3, 0, op);
        int reduction4 = reduce(ints4, 0, op);

        int reduction = reduce(ints, 0, op);
        int reductionParallelSimulation = reduce(Arrays.asList(reduction1, reduction2), 0, op);
        int reductionParallelSimulationAndDifferentDistrubution = reduce(Arrays.asList(reduction3, reduction4), 0, op);

        System.out.println("Reduction :" + reduction);
        System.out.println("Reduction parallel simulation:" + reductionParallelSimulation);
        System.out.println("Reduction parallel simulation but different distribution of values: "
                + reductionParallelSimulationAndDifferentDistrubution);

    }
}
