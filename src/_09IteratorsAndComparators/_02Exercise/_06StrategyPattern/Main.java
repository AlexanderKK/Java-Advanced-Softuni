package _09IteratorsAndComparators._02Exercise._06StrategyPattern;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> peopleByName = new TreeSet<>(new NameComparator());
        Set<Person> peopleByAge = new TreeSet<>(new AgeComparator());

        int n = Integer.parseInt(scanner.nextLine());

        if(n < 0 || n > 100) {
            return;
        }

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");

            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);

            validData(name, age);

            peopleByName.add(new Person(name, age));
            peopleByAge.add(new Person(name, age));
        }

        //Sorted by name
        peopleByName.forEach(System.out::println);

//        peopleByName = new TreeSet<>(peopleByName);
//        peopleByName = peopleByName.stream().sorted().collect(Collectors.toSet());


        //Sorted by age
        peopleByAge.forEach(System.out::println);
    }

    private static void validData(String name, int age) {
        if(name.length() < 1 || name.length() > 50 || age < 0 || age > 100) {
            throw new IllegalArgumentException("Invalid name or age");
        }
    }
}
