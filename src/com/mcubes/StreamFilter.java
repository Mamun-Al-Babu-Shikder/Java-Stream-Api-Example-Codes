package com.mcubes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream<T> filter(Predicate<? super T> predicate)
 * Returns a stream consisting of the elements of this stream that match the given predicate.
 * This is an intermediate operation.
 *
 * Parameters:
 * predicate - a non-interfering, stateless predicate to apply to each element to determine if it should be included
 *
 * Returns:
 * the new stream
 */
public class StreamFilter {

    public static void main(String[] args) {

        /**
         * Let's try to filter odd number of given list using anonymous inner class
         */
        System.out.println("Example of filter(Predicate<? super T> predicate): Using anonymous inner class");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream1 = list1.stream();
        List<Integer> oddNumbers1 = stream1.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 != 0;
            }
        }).collect(Collectors.toList());
        System.out.println(oddNumbers1);

        /**
         * Let's try to filter odd number of given list using lambda
         */
        System.out.println("\nExample of filter(Predicate<? super T> predicate): Using lambda");
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream2 = list2.stream();
        List<Integer> oddNumbers2 = stream2.filter((i)->i % 2 != 0).collect(Collectors.toList());
        System.out.println(oddNumbers2);
    }
}
