package com.mcubes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * forEach(Consumer<? super T> action)
 * Performs an action for each element of this stream.
 * This is a terminal operation.
 * The behavior of this operation is explicitly nondeterministic.
 * For parallel stream pipelines, this operation does not guarantee to respect
 * the encounter order of the stream, as doing so would sacrifice the benefit of parallelism.
 * For any given element, the action may be performed at whatever time and in whatever thread the library chooses.
 * If the action accesses shared state, it is responsible for providing the required synchronization.
 */

public class StreamForEach {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        System.out.println("First Approach: Using anonymous inner class");
        Stream<Integer> stream1 = list.stream();
        /**
         * Let's create an anonymous inner class of Consumer @Functional interface
         * that consume integer value that will pass by the stream.
         */
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        // Pass the consumer object through forEach method.
        stream1.forEach(consumer);

        /**
         * forEach() method with lambda
         */
        System.out.println("\nSecond Approach: Using lambda");
        Stream<Integer> stream2 = list.stream();
        stream2.forEach(integer -> System.out.println(integer));

        /**
         * forEach() method with method reference.
         * Reference method will be as like as accept() method that exist inside
         * java.util.function.Consumer interface.
         */
        System.out.println("\nThird Approach: Using method reference");
        Stream<Integer> stream3 = list.stream();
        stream3.forEach(StreamForEach::print);
    }

    public static void print(Integer integer){
        System.out.println(integer);
    }
}
