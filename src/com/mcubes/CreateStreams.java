package com.mcubes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Let's try to know about the different way to create a java stream.
 */
public class CreateStreams {

    public static void main(String[] args) {

        /**
         * Stream.of()
         * creating a stream of a fixed number of integers.
         */
        System.out.println("Stream.of():");
        Stream<Integer> stream1 = Stream.of(0,1,2,3,4,5,6,7,8,9);
        stream1.forEach(System.out::println); // print each element of the stream

        /**
         * Stream.of(array)
         * creating a stream from the array.
         * The elements in the stream are taken from the array.
         */
        System.out.println("\nStream.of(array):");
        Integer[] array = {0,1,2,3,4,5,6,7,8,9};
        Stream<Integer> stream2 = Stream.of(array);
        stream2.forEach(System.out::println); // print each element of the stream

        /**
         * List.stream()
         * creating a stream from the List.
         * The elements in the stream are taken from the List.
         */
        System.out.println("\nList.stream():");
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++){
            list.add(i);
        }
        Stream<Integer> stream3 = list.stream();
        stream3.forEach(System.out::println); // print each element of the stream



    }
}
