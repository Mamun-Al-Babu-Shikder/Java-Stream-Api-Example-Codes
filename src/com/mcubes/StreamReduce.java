package com.mcubes;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class StreamReduce {

    public static void main(String[] args) {

        /**
         * Optional<T> reduce(BinaryOperator<T> accumulator)
         * Performs a reduction on the elements of this stream, using an associative accumulation function,
         * and returns an Optional describing the reduced value, if any. This is a terminal operation.
         * Like Many to One operation.
         *
         * Parameters:
         * accumulator - an associative, non-interfering, stateless function for combining two values
         *
         * Returns:
         * an Optional describing the result of the reduction
         *
         * Throws:
         * NullPointerException - if the result of the reduction is null
         */
        System.out.println("Example of reduce(BinaryOperator<T>): Using anonymous inner class");
        List<String> list1 = Arrays.asList("Java ", "is ", "a ", "powerful ", "programming ", "language.");
        Stream<String> stream1 = list1.stream();
        BinaryOperator<String> binaryOperator1 = new BinaryOperator<String>() {
            @Override
            public String apply(String s1, String s2) {
                return s1.concat(s2);
            }
        };
        Optional<String> optional1 = stream1.reduce(binaryOperator1);
        System.out.println("Concat Value: " + optional1.get());

        /**
         * reduce(BinaryOperator<T>) example using lambda.
         */
        System.out.println("\nExample of reduce(BinaryOperator<T>) method: Using lambda");
        List<String> list2 = Arrays.asList("Java ", "is ", "a ", "powerful ", "programming ", "language.");
        Stream<String> stream2 = list2.stream();
        Optional<String> optional2 = stream2.reduce((s1, s2)->s1.concat(s2));
        // Optional<String> optional2 = stream2.reduce(String::concat); // using method reference
        System.out.println("Concat Value: " + optional2.get());





        /**
         * T reduce(T identity, BinaryOperator<T> accumulator)
         * Performs a reduction on the elements of this stream,
         * using the provided identity value and an associative accumulation function, and returns the reduced value.
         *
         * Parameters:
         * identity - the identity value for the accumulating function
         * accumulator - an associative, non-interfering, stateless function for combining two values
         *
         * Returns:
         * the result of the reduction
         */

        System.out.println("\nExample of reduce(T identity, BinaryOperator<T> accumulator): Using anonymous inner class");
        List<Integer> list3 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream3 = list3.stream();

        Integer identity1 = 5;
        Integer sum1 = stream3.reduce(identity1, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer1, Integer integer2) {
                return integer1 + integer2;
            }
        });
        System.out.println("Sum: " + sum1);


        /**
         * reduce(T identity, BinaryOperator<T> accumulator): Using lambda
         */
        System.out.println("\nExample of reduce(T identity, BinaryOperator<T> accumulator): Using lambda");
        List<Integer> list4 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> stream4 = list4.stream();
        Integer identity2 = 10;
        Integer sum2 = stream4.reduce(identity2, (a, b)-> a+b);
        System.out.println("Sum: " +  sum2);




        /**
         * <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
         * Performs a reduction on the elements of this stream, using the provided identity,
         * accumulation and combining functions. This is a terminal operation.
         *
         * Type Parameters:
         * U - The type of the result
         *
         * Parameters:
         * identity - the identity value for the combiner function
         *
         * Returns:
         * the result of the reduction
         */
        System.out.println("\nExample of reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner): Using anonymous inner class");
        List<Integer> list5 = Arrays.asList(1,2,3,4,5,7,8,9);
        Stream<Integer> stream5 = list5.stream();

        Integer identity3 = 0;
        Integer value1 = stream5.parallel().reduce(identity3, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer1, Integer integer2) {
                return integer1 + integer2;
            }
        }, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer1, Integer integer2) {
                return integer1 + integer2;
            }
        });
        System.out.println("Value: " + value1);


        /**
         *  reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner): Using lambda
         */
        System.out.println("\nExample of reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner): Using lambda");
        List<Integer> list6 = Arrays.asList(1,2,3,4,5,7,8,9);
        Stream<Integer> stream6 = list6.stream();

        Integer identity4 = 0;
        Integer value2 = stream6.reduce(
                identity4,
                (a,b)-> a + b,
                (c,d)->c+d
        );
        System.out.println("Value: " + value2);

    }
}
