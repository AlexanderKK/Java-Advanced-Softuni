package _09IteratorsAndComparators._02Exercise._05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String command;
        while(!"END".equals(command = scanner.nextLine())) {
            String[] inputArr = command.split("\\s+");

            String name = inputArr[0];
            int age = Integer.parseInt(inputArr[1]);
            String town = inputArr[2];

            people.add(new Person(name, age, town));
        }

        int mainPersonIndex = Integer.parseInt(scanner.nextLine()) - 1;

        int samePeople = 0;
        int differentPeople = 0;

        Person mainPerson = people.get(mainPersonIndex);

        for (Person person : people) {
            if(person.compareTo(mainPerson) == 0) {
                samePeople++;
            } else {
                differentPeople++;
            }
        }

        if(samePeople != 1) {
            System.out.printf("%d %d %d%n", samePeople, differentPeople, people.size());
        } else {
            System.out.println("No matches");
        }
    }
}
