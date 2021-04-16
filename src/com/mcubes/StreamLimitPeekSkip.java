package com.mcubes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLimitPeekSkip {

    public static void main(String[] args) {

        /**
         * Stream<T> limit(long maxSize)
         * Returns a stream consisting of the elements of this stream,
         * truncated to be no longer than maxSize in length.
         * This is an intermediate operation.
         *
         * Parameters:
         * maxSize - the number of elements the stream should be limited to
         *
         * Returns:
         * the new stream
         *
         * Throws:
         * IllegalArgumentException - if maxSize is negative
         */
        System.out.println("Example of limit(long maxSize) method:");
        List<Integer> list1 = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream1 = list1.stream().limit(5);
        stream1.forEach(System.out::println);

        /**
         * Stream<T> peek(Consumer<? super T> action)
         * Returns a stream consisting of the elements of this stream,
         * additionally performing the provided action on each element as
         * elements are consumed from the resulting stream.
         * This is an intermediate operation.
         *
         * Parameters:
         * action - a non-interfering action to perform on the elements as they are consumed from the stream
         *
         * Returns:
         * the new stream
         */
        System.out.println("\nExample of peek(Consumer<? super T> action) method:");
        List<Integer> list2 = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        List<Integer> values = list2.stream()
                .filter(integer->integer%2==0)
                .peek(v-> System.out.println("Peeked value: " + v))
                .collect(Collectors.toList());
        System.out.println(values);

        /**
         * Stream<T> skip(long n)
         * Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream.
         * If this stream contains fewer than n elements then an empty stream will be returned.
         * This is an intermediate operation.
         *
         * Parameters:
         * n - the number of leading elements to skip
         *
         * Returns:
         * the new stream
         *
         * Throws:
         * IllegalArgumentException - if n is negative
         */
        System.out.println("\nExample of skip(long n) method:");
        List<Integer> list3 = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream3 = list3.stream().skip(5);
        stream3.forEach(System.out::println);
    }
}
