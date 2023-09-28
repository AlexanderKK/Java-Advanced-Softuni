package _06DefiningClasses._02Exercise._01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            people.add( new Person(data[0], Integer.parseInt(data[1])) );
        }

//        List<Person> toSort = new ArrayList<>();
//        for (Person p : people) {
//            if (p.age() > 30) {
//                toSort.add(p);
//            }
//        }
//        toSort.sort(Comparator.comparing(Person::name));
//        for (Person p : toSort) {
//            System.out.println(p);
//        }

        people.stream()
                .filter(p -> p.age() > 30)
                .sorted(Comparator.comparing(Person::name))
                .forEach(System.out::println);
    }
}
