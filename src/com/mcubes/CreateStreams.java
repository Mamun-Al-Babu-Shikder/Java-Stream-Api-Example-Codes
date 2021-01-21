package com.mcubes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
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

        /**
         * Stream.generate()
         * creating a stream from generated elements.
         * This will produce a stream of 10 random numbers.
         * We have restricted the elements count using limit() function.
         */
        System.out.println("\nStream.generate():");
        Stream<Integer> stream4 = Stream.generate(()->new Random().nextInt(10));
        stream4.limit(10).forEach(System.out::println); // print each element of the stream

        /**
         * Stream of String chars
         * creating a stream from the characters of a given string.
         * "String".chars() method return an IntStream.
         */
        System.out.println("\nStream of String chars:");
        IntStream stream5 = "Hello_World".chars();
        stream5.forEach(System.out::println); // print each element of the stream. every element an int value

        /**
         * Stream tokens
         * creating the stream of tokens received from splitting from a string.
         */
        System.out.println("\nStream tokens:");
        String s = "White,Black,Red,Green,Gray,Orange";
        Stream<String> stream6 = Stream.of(s.split(","));
        stream6.forEach(System.out::println);

    }
}
