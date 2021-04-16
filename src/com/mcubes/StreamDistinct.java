package com.mcubes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDistinct {

    public static void main(String[] args) {

        /**
         * Stream<T> distinct()
         * Returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.
         *
         * Returns:
         * the new stream
         */
        System.out.println("Example of distinct() method:");
        List<Integer> list1 = Arrays.asList(1,1,2,3,4,1,2,3,4,5,6,7,4,5,6,8,9,3,9,1,5);
        Stream<Integer> stream1 = list1.stream().distinct();
        stream1.forEach(System.out::println);

        /**
         * Stream<T> distinct() method for custom Object type:
         * Let assume in this case our custom object type is 'Book'.
         * There have some fields like 'id', 'name', 'price'.
         * We want to district them according to name.
         */
        System.out.println("\nExample of distinct() method for custom type:");
        List<Book> list2 = Arrays.asList(
                new Book(101, "C", 350.00f),
                new Book(102, "C++", 360.50f),
                new Book(103, "Java", 950.00f),
                new Book(104, "Python", 450.0f),
                new Book(105, "C++", 489.99f),
                new Book(106, "Python", 499.99f),
                new Book(107, "Java", 699.99f)
        );

        Stream<Book> stream2 = list2.stream().distinct();
        stream2.forEach(System.out::println);

    }
}

class Book {
    private int id;
    private String name;
    private float price;

    public Book(int id, String name, float price) {
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
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Book book = (Book) o;
        return this.name.equals(book.getName());
    }
}


