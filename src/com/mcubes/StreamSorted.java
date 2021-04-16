package com.mcubes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSorted {

    public static void main(String[] args) {

        /**
         * Stream<T> sorted()
         * Returns a stream consisting of the elements of this stream,
         * sorted according to natural order. If the elements of this stream are not Comparable,
         * a java.lang.ClassCastException may be thrown when the terminal operation is executed.
         *
         * This is an intermediate operation.
         *
         * Returns:
         * the new stream
         */
        System.out.println("Example of sorted() method:");
        List<Integer> list1 = Arrays.asList(9,1,6,8,2,5,3,4,7);
        Stream<Integer> stream1 = list1.stream().sorted();
        stream1.forEach(System.out::println);

        /**
         * Stream<T> sorted(Comparator<? super T> comparator)
         * Returns a stream consisting of the elements of this stream,
         * sorted according to the provided Comparator.
         *
         * Parameters:
         * comparator - a non-interfering, stateless Comparator to be used to compare stream elements
         *
         * Returns:
         * the new stream
         */
        System.out.println("\nExample of sorted(Comparator<? super T> comparator) method:");
        List<Integer> list2 = Arrays.asList(9,1,6,8,2,5,3,4,7);
        Stream<Integer> stream2 = list2.stream()
                .sorted((a, b)-> b - a); // Sort with descending order
        stream2.forEach(System.out::println);

        /**
         * Stream<T> sorted(Comparator<? super T> comparator) for custom object type:
         * Consider we have custom object type 'Product' with fields 'id', 'name' and 'price'.
         * We want to sort the products according to price.
         */
        System.out.println("\nExample of sorted(Comparator<? super T> comparator) method for custom object:");
        List<Product> list3 = Arrays.asList(
                new Product(101, "Titan Watch", 2500.00f),
                new Product(102, "Dell Laptop", 55000.00f),
                new Product(103, "Nokia Phone", 25500.00f),
                new Product(104, "HP LED Monitor", 7999.99f)
        );
        Stream<Product> stream3 = list3.stream().sorted();
        stream3.forEach(System.out::println);

    }
}

class Product implements Comparable<Product> {

    private int id;
    private String name;
    private float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return this.price < product.getPrice() ? 1 : -1;
    }
}
