package com.mcubes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

    public static void main(String[] args) {

        /**
         * <R> Stream<R> map(Function<? super T,? extends R> mapper)
         * Returns a stream consisting of the results of applying the given function to the elements of this stream.
         * This is an intermediate operation.
         *
         * Type Parameters:
         * R - The element type of the new stream
         *
         * Parameters:
         * mapper - a non-interfering, stateless function to apply to each element
         *
         * Returns:
         * the new stream
         */
        /**
         * <R> Stream<R> map(Function<? super T,? extends R> mapper) using anonymous inner class
         */
        System.out.println("Example of map(Function<? super T,? extends R> mapper): Using anonymous inner class");
        List<Employee> list1 = new ArrayList<>();
        list1.add(new Employee(101, "Rahim", 25000));
        list1.add(new Employee(102, "Karim", 22000));
        list1.add(new Employee(103, "Sujon", 20000));
        list1.add(new Employee(104, "Hamid", 25000));

        Stream<Employee> stream1 = list1.stream();
        List<String> employeeNames1 = stream1.map(new Function<Employee, String>() {
            @Override
            public String apply(Employee employee) {
                return employee.getName();
            }
        }).collect(Collectors.toList());
        System.out.println(employeeNames1);

        /**
         * <R> Stream<R> map(Function<? super T,? extends R> mapper) using lambda
         */
        System.out.println("\nExample of map(Function<? super T,? extends R> mapper): Using lambda");
        List<Employee> list2 = new ArrayList<>();
        list2.add(new Employee(101, "Rahim", 25000));
        list2.add(new Employee(102, "Karim", 22000));
        list2.add(new Employee(103, "Sujon", 20000));
        list2.add(new Employee(104, "Hamid", 25000));

        Stream<Employee> stream2 = list2.stream();
        List<String> employeeNames2 = stream2.map((e)->e.getName()).collect(Collectors.toList());
        System.out.println(employeeNames2);
    }
}

class Employee {

    private Integer id;
    private String name;
    private double salary;

    public Employee(Integer id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
