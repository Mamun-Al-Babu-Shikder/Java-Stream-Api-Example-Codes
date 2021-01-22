package com.mcubes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * boolean noneMatch(Predicate<? super T> predicate)
 * Returns whether no elements of this stream match the provided predicate.
 * May not evaluate the predicate on all elements if not necessary for determining the result.
 * If the stream is empty then true is returned and the predicate is not evaluated.
 *
 * Parameters:
 * predicate - a non-interfering, stateless predicate to apply to elements of this stream.
 *
 * Returns:
 * true if either no elements of the stream match the provided predicate or the stream is empty, otherwise false
 */
public class StreamNoneMatch {

    public static void main(String[] args) {

        /**
         * Create an list witch contain odd numbers only.
         * create a Predicate that test our provided logic.
         */
        System.out.println("First Approach: Using anonymous inner class");
        List<Integer> list1 = Arrays.asList(1,3,5,7,9);
        Stream<Integer> stream1 = list1.stream();
        boolean result1 = stream1.noneMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                //TODO : Our logic here.
                return integer % 2 == 0;
            }
        });
        System.out.println(result1);

        /**
         * Let's try above using lambda.
         */
        System.out.println("\nSecond Approach: Using lambda");
        List<Integer> list2 = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream2 = list2.stream();
        boolean result2 = stream2.noneMatch(integer -> integer % 2 == 0); // Our logic here. for multiple line use body like {}
        System.out.println(result2);

    }
}
