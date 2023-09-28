package _05FunctionalProgramming._01Lab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _05FilterByAge {
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Function<Scanner, Person> readPerson = sc -> {
            String[] inputLine = sc.nextLine().split(", ");

            String name = inputLine[0];
            int age = Integer.parseInt(inputLine[1]);

            Person person = new Person(name, age);

            return person;
        };

        List<Person> people = IntStream.range(1, n + 1)
                .mapToObj(i -> readPerson.apply(scanner))
                .collect(Collectors.toList());

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> ageFilter = getFilter(condition, age);

        Consumer<Person> printFormat = getPrintFormat(format);

        people.stream()
                .filter(ageFilter)
                .forEach(printFormat);
    }

    private static Predicate<Person> getFilter(String condition, int age) {
        switch (condition) {
            case "older":
                return p -> p.age >= age;
            case "younger":
                return p -> p.age <= age;
            default:
                throw new IllegalArgumentException("Unknown condition " + condition);
        }
    }

    private static Consumer<Person> getPrintFormat(String format) {
        switch (format) {
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p -> System.out.println(p.age);
            case "name age":
                return p -> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("Unknown format " + format);
        }
    }
}