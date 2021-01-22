package com.mcubes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Optional<T> findAny()
 * Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
 * This is a short-circuiting terminal operation. The behavior of this operation is explicitly nondeterministic;
 * it is free to select any element in the stream. This is to allow for maximal performance in parallel operations;
 * the cost is that multiple invocations on the same source may not return the same result.
 * (If a stable result is desired, use findFirst() instead.)
 *
 * Returns:
 * an Optional describing some element of this stream, or an empty Optional if the stream is empty
 *
 * Throws:
 * NullPointerException - if the element selected is null
 */
public class StreamFindAny {

    public static void main(String[] args) {
        /**
         * Let's create a list that contains some integer.
         * Create a stream with the help of that list.
         * Use findAny() method to get an integer from that list.
         */
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream1 = list.stream();
        Optional<Integer> optional =  stream1.findAny();
        if (optional.isPresent()){
            System.out.println("Found: " + optional.get());
        }else {
            System.out.println("Not found.");
        }

    }
}
