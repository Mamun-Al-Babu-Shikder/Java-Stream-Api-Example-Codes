package com.mcubes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * void forEachOrdered(Consumer<? super T> action)
 * Performs an action for each element of this stream,
 * in the encounter order of the stream if the stream has a defined encounter order.
 * It always maintain order although stream is parallel.
 * This is a terminal operation.
 *
 * Parameters:
 * action - a non-interfering action to perform on the elements
 */

public class StreamForEachOrdered {

    public static void main(String[] args) {

        /**
         * forEachOrdered(Consumer<? super T> action) using anonymous inner class
         */
        System.out.println("Example forEachOrdered(Consumer<? super T> action): Using anonymous inner class");
        List<Integer> list1 = Arrays.asList(1,2,3,4,6,7,8,9);
        list1.stream().forEachOrdered(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        /**
         * forEachOrdered(Consumer<? super T> action) using lambda
         * with parallel stream.
         */
        System.out.println("\nExample forEachOrdered(Consumer<? super T> action): Using lambda");
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        list2.stream().parallel().forEachOrdered((value)-> System.out.println(value));
    }
}