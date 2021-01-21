package com.mcubes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * boolean allMatch(Predicate<? super T> predicate)
 * Returns whether all elements of this stream match the provided predicate.
 * May not evaluate the predicate on all elements if not necessary for determining the result.
 * If the stream is empty then true is returned and the predicate is not evaluated.
 *
 * Parameters:
 * predicate - a non-interfering, stateless predicate to apply to elements of this stream
 *
 * Returns:
 * true if either all elements of the stream match the provided predicate or the stream is empty, otherwise false
 */

public class StreamAllMatch {

    public static void main(String[] args) {

        /**
         * Create an list witch contain odd and even numbers.
         * create a Predicate that check the even numbers. and pass it into allMatch() method.
         */
        System.out.println("First Approach: Using anonymous inner class");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream1 = list1.stream();
        boolean result1 = stream1.allMatch(new Predicate<Integer>() {
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
        List<Integer> list2 = Arrays.asList(2,4,6,8);
        Stream<Integer> stream2 = list2.stream();
        boolean result2 = stream2.allMatch(integer -> integer % 2 == 0); // Our logic here. for multiple line use body like {}
        System.out.println(result2);
    }
}
