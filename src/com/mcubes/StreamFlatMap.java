package com.mcubes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
 * Returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.
 * Each mapped stream is closed after its contents have been placed into this stream. (If a mapped stream is null an empty stream is used, instead.)
 * This is an intermediate operation.
 *
 * Type Parameters:
 * R - The element type of the new stream
 *
 * Parameters:
 * mapper - a non-interfering, stateless function to apply to each element which produces a stream of new values
 *
 * Returns:
 * the new stream
 */
public class StreamFlatMap {

    public static void main(String[] args) {

        /**
         * <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper) using anonymous inner class
         */
        System.out.println("Example of flatMap(Function<? super T,? extends Stream<? extends R>> mapper): Using anonymous inner class");
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(101, "Akash", Arrays.asList("Java", "Kotlin")));
        list1.add(new Student(102, "Samira", Arrays.asList("Html", "CSS", "Java Script")));
        list1.add(new Student(103, "Shahin", Arrays.asList("C", "C++")));
        list1.add(new Student(104, "Latif", Arrays.asList("Python", "R lang")));

        Stream<Student> stream1 = list1.stream();
        List<String> courses1 =  stream1.flatMap(new Function<Student, Stream<String>>() {
            @Override
            public Stream<String> apply(Student student) {
                return student.getCourses().stream();
            }
        }).collect(Collectors.toList());
        System.out.println(courses1);

        /**
         * <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper) using lambda
         */
        System.out.println("\nExample of flatMap(Function<? super T,? extends Stream<? extends R>> mapper): Using lambda");
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(101, "Akash", Arrays.asList("Java", "Kotlin")));
        list2.add(new Student(102, "Samira", Arrays.asList("Html", "CSS", "Java Script")));
        list2.add(new Student(103, "Shahin", Arrays.asList("C", "C++")));
        list2.add(new Student(104, "Latif", Arrays.asList("Python", "R lang")));

        Stream<Student> stream2 = list2.stream();
        List<String> courses2 = stream2.flatMap(student->student.getCourses().stream())
                .collect(Collectors.toList());
        System.out.println(courses2);
    }
}

class Student {

    private Integer id;
    private String name;
    private List<String> courses;

    public Student(Integer id, String name, List<String> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getCourses() {
        return courses;
    }
}
