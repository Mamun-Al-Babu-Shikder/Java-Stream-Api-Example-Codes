package com.mcubes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Stream;


public class StreamToArray {

    public static void main(String[] args) {


        /**
         * Object[] toArray()
         * Returns an array containing the elements of this stream.
         * This is a terminal operation.
         *
         * Returns:
         * an array containing the elements of this stream
         */

        System.out.println("Example of toArray():");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream1 = list1.stream();
        Object[] array1 = stream1.toArray();
        System.out.println(Arrays.toString(array1));


        /**
         * <A> A[] toArray(IntFunction<A[]> generator)
         * Returns an array containing the elements of this stream,
         * using the provided generator function to allocate the returned array,
         * as well as any additional arrays that might be required for a partitioned execution or for resizing.
         * This is a terminal operation.
         *
         * Type Parameters:
         * A - the element type of the resulting array
         *
         * Parameters:
         * generator - a function which produces a new array of the desired type and the provided length
         *
         * Returns:
         * an array containing the elements in this stream
         *
         * Throws:
         * ArrayStoreException - if the runtime type of the array returned from the array generator is not a supertype of the runtime type of every element in this stream
         */

        /**
         * toArray(IntFunction<A[]> generator) Using inner class
         */
        System.out.println("\nExample of toArray(IntFunction<A[]> generator): Using anonymous inner class");
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream2 = list2.stream();
        Integer[] array2 = stream2.<Integer>toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int i) {
                return new Integer[i];
            }
        });
        System.out.println(Arrays.toString(array2));

        /**
         * toArray(IntFunction<A[]> generator) Using lambda
         */
        System.out.println("\nExample of toArray(IntFunction<A[]> generator): Using lambda");
        List<Integer> list3 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream3 = list3.stream();
        Integer[] array3 = stream3.<Integer>toArray((i)->new Integer[i]);
        System.out.println(Arrays.toString(array3));



    }
}
