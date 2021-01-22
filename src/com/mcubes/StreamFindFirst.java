package com.mcubes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Optional<T> findFirst()
 * Returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty.
 * If the stream has no encounter order, then any element may be returned.
 * This is a short-circuiting terminal operation.
 *
 * Returns:
 * an Optional describing the first element of this stream, or an empty Optional if the stream is empty
 *
 * Throws:
 * NullPointerException - if the element selected is null
 */
public class StreamFindFirst {

    public static void main(String[] args) {
        /**
         * Let's create a list that contains some integer.
         * Create a stream with the help of that list.
         * Use findFirst() method to get first element from that list.
         */
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream = list.stream();
        Optional<Integer> optional =  stream.findFirst();
        if (optional.isPresent()){
            System.out.println("Found: " + optional.get());
        }else {
            System.out.println("Not found.");
        }
    }
}
