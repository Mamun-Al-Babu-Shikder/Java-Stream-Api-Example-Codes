package com.mcubes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * boolean anyMatch(Predicate<? super T> predicate)
 * Returns whether any elements of this stream match the provided predicate.
 * May not evaluate the predicate on all elements if not necessary for determining the result.
 * If the stream is empty then false is returned and the predicate is not evaluated.
 *
 * Parameters:
 * predicate - a non-interfering, stateless predicate to apply to elements of this stream
 *
 * Returns:
 * true if any elements of the stream match the provided predicate, otherwise false
 */

public class StreamAnyMatch {

    public static void main(String[] args) {

        /**
         * Create an list witch contain odd and even numbers.
         * create a Predicate that check the specific number is exist or not.
         */
        System.out.println("First Approach: Using anonymous inner class");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream1 = list1.stream();
        boolean result1 = stream1.anyMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                //TODO : Our logic here.
                return integer == 3;
            }
        });
        System.out.println(result1);


        /**
         * Let's try above using lambda.
         */
        System.out.println("\nSecond Approach: Using lambda");
        List<Integer> list2 = Arrays.asList(0,2,4,6,8);
        Stream<Integer> stream2 = list2.stream();
        boolean result2 = stream2.allMatch(integer -> integer == 3); // Our logic here. for multiple line use body like {}
        System.out.println(result2);
    }
}
