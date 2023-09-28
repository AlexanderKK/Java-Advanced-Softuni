package _09IteratorsAndComparators._02Exercise._07EqualityLogic;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> peopleHashSet = new HashSet<>();
        Set<Person> peopleTreeSet = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        if(n < 0 || n > 100) {
            return;
        }

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");

            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);

            validData(name, age);

            peopleHashSet.add(new Person(name, age));
            peopleTreeSet.add(new Person(name, age));
        }

        System.out.println(peopleHashSet.size());
        System.out.println(peopleTreeSet.size());

//        //Sorted HashSet
//        System.out.println(peopleHashSet
//                .stream()
//                .sorted(new HashSetComparator())
//                .map(Person::toString)
//                .collect(Collectors.joining(", ")));
//
//        //HashSet Contents
//        System.out.println(peopleHashSet.size() + ": " + peopleHashSet
//                .stream()
//                .map(Person::toString)
//                .collect(Collectors.joining(", ")));
//
//        //TreeSet Contents
//        System.out.println(peopleTreeSet.size() + ": " + peopleTreeSet
//                .stream()
//                .map(Person::toString)
//                .collect(Collectors.joining(", ")));
    }

    private static void validData(String name, int age) {
        if(name.length() < 1 || name.length() > 50 || age < 0 || age > 100) {
            throw new IllegalArgumentException("Invalid name or age");
        }
    }
}
