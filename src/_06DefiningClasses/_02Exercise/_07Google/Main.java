package _06DefiningClasses._02Exercise._07Google;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String command;
        while(!"End".equals(command = scanner.nextLine())) {
            String[] data = command.split(" ");

            String name = data[0];
            String subClass = data[1];

            boolean isPersonPresent = people.stream()
                    .anyMatch(p -> p.getName().equals(name));
            if(!isPersonPresent) {
                Person person = new Person(name);
                people.add(person);
            }

            Person currentPerson = people.stream()
                    .filter(p -> p.getName().equals(name))
                    .findFirst()
                    .get();

            if(subClass.equals("company")) {
                String companyName = data[2];
                String department = data[3];
                double salary = Double.parseDouble(data[4]);

                Company company = new Company(companyName, department, salary);
                currentPerson.setCompany(company);
            } else if(subClass.equals("car")) {
                String carModel = data[2];
                int carSpeed = Integer.parseInt(data[3]);

                Car car = new Car(carModel, carSpeed);
                currentPerson.setCar(car);
            } else if(subClass.equals("pokemon")) {
                String pokemonName = data[2];
                String pokemonType = data[3];

                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                currentPerson.getPokemons().add(pokemon);
            } else if(subClass.equals("parents")) {
                String parentName = data[2];
                String parentBirthDate = data[3];

                Parent parent = new Parent(parentName, parentBirthDate);
                currentPerson.getParents().add(parent);
            } else if(subClass.equals("children")) {
                String childName = data[2];
                String childBirthDate = data[3];

                Child child = new Child(childName, childBirthDate);
                currentPerson.getChildren().add(child);
            }
        }

        String personName = scanner.nextLine();

        Person person = people.stream()
                .filter(p -> p.getName().equals(personName))
                .findAny()
                .get();

        System.out.println(person);
    }
}
