package com.mcubes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamCountMaxMin {

    public static void main(String[] args) {

        /**
         * long count()
         * Returns the count of elements in this stream. This is a terminal operation.
         *
         * Returns:
         * the count of elements in this stream.
         */
        System.out.println("Example of count() method:");
        List<Integer> list1 = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        Stream stream1 = list1.stream();
        long count = stream1.count();
        System.out.println("Count: " + count);

        /**
         * Optional<T> max(Comparator<? super T> comparator)
         * Returns the maximum element of this stream according to the provided Comparator.
         * This is a special case of a reduction. This is a terminal operation.
         *
         * Parameters:
         * comparator - a non-interfering, stateless Comparator to compare elements of this stream
         *
         * Returns:
         * an Optional describing the maximum element of this stream, or an empty Optional if the stream is empty
         *
         * Throws:
         * NullPointerException - if the maximum element is null
         */
        System.out.println("\nExample of max() method: Using anonymous inner class");
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream2 = list2.stream();
        Optional<Integer> optional1 = stream2.max(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer1, Integer integer2) {
                return integer1 - integer2;
            }
        });
        System.out.println("MAX Value: " + optional1.get());


        /**
         * max() example using lambda.
         */
        System.out.println("\nExample of max() method: Using lambda");
        List<Integer> list3 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream3 = list3.stream();
        Optional<Integer> optional2 = stream3.max((a,b)->a-b);
        System.out.println("MAX Value: " + optional2.get());


        /**
         * Optional<T> min(Comparator<? super T> comparator)
         * Returns the minimum element of this stream according to the provided Comparator.
         * This is a special case of a reduction. This is a terminal operation.
         *
         * Parameters:
         * comparator - a non-interfering, stateless Comparator to compare elements of this stream
         *
         * Returns:
         * an Optional describing the minimum element of this stream, or an empty Optional if the stream is empty
         *
         * Throws:
         * NullPointerException - if the minimum element is null
         */
        System.out.println("\nExample of min() method: Using anonymous inner class");
        List<Integer> list4 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream4 = list4.stream();
        Optional<Integer> optional3 = stream4.min(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer1, Integer integer2) {
                return integer1 - integer2;
            }
        });
        System.out.println("MIN Value: " + optional3.get());


        /**
         * min() example using lambda.
         */
        System.out.println("\nExample of min() method: Using lambda");
        List<Integer> list5 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream5 = list5.stream();
        Optional<Integer> optional4 = stream5.min((a,b)->a-b);
        System.out.println("MIN Value: " + optional4.get());

    }
}
