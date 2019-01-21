package com.ns.training.reducestepproblems;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class CaveatTwoReductionWithNotIdentityElement {

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
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, -1, -2, -3, -4);

        List<Integer> ints1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(-1, -2, -3, -4);




        /*
        In this example we are sum and multiply so is not an accumulative operation because the operator are not
        the same, so it will return different results, and if we change the content of the list int1 and int2 for
        example
        List<Integer> ints1 = Arrays.asList(1,2);
        List<Integer> ints2 = Arrays.asList(3,4,5, 6, 7, 8, 9);
        it will return another result yet in a parallel way, it happen the same with:
         BinaryOperator<Integer> op = (i1, i2) -> (i1 + i2) / 2; that represent the average
         */
        BinaryOperator<Integer> op = (i1, i2) -> Integer.max(i1, i2);

        int reduction1 = reduce(ints1, 0, op);
        int reduction2 = reduce(ints2, 0, op);

        System.out.println("Reduction1 " + reduction1);
        /*
        When we introduce a negative numbers, as max do not has identity element and we are specify the 0 as
        default value, it will take that value even if zero is not the expected value, in tthis case of
        -1,-2,-3,-4 the max should be -1 and not 0, so we need to be very careful with this kind of operations
        this is only happend if we have negatives, if we just have positives there is no problem at all
         */
        System.out.println("Reduction2 " + reduction2);

    }
}
