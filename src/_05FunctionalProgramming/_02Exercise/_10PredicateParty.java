package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10PredicateParty {
    public static List<String> people;
    public static BiFunction<String, String, Integer> timesOccurred;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Read people
        people = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        //Function for person occurrence times
        timesOccurred = (condition, subStr) -> {
            int times = 0;

            for (String element : people) {
                if(condition.equals("Length")) {
                    int length = Integer.parseInt(subStr);

                    if(element.length() == length) {
                        times++;
                    }
                } else if(condition.equals("StartsWith")) {
                    if(element.startsWith(subStr)) {
                        times++;
                    }
                } else if(condition.equals("EndsWith")) {
                    if(element.endsWith(subStr)) {
                        times++;
                    }
                }
            }

            return times;
        };

        String command;
        while(!"Party!".equals(command = scanner.nextLine())) {
            if(command.startsWith("Remove")) {
                String condition = command.split(" ")[1];
                String subStr = command.split(" ")[2];

                //Remove person by filter
                Predicate<String> personFilter = getFilterRemove(condition, subStr);

                people.removeIf(personFilter);
            } else if(command.startsWith("Double")) {
                String condition = command.split(" ")[1];
                String subStr = command.split(" ")[2];

                //Double person by consumer
                Consumer<List<String>> personConsumer = getConsumerDouble(condition, subStr);

                personConsumer.accept(people);
            }
        }

        printPeople();
    }

    private static void printPeople() {
        if(people.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(
                    people.stream()
                    .sorted()
                    .collect(Collectors.joining(", ")) + " are going to the party!"
            );
        }
    }

    private static Consumer<List<String>> getConsumerDouble(String condition, String subStr) {
        return elements -> {
            int times = timesOccurred.apply(condition, subStr);

            for (int i = 0; i < elements.size(); i++) {
                String element = elements.get(i);

                if(condition.equals("StartsWith") && element.startsWith(subStr)) {
                    elements.add(i, element);
                    times--;
                } else if(condition.equals("EndsWith") && element.endsWith(subStr)) {
                    elements.add(i, element);
                    times--;
                } else if(condition.equals("Length")) {
                    int length = Integer.parseInt(subStr);

                    if(element.length() == length) {
                        elements.add(i, element);
                        times--;
                    }
                }

                if(times == 0) {
                    break;
                }
            }
        };
    }

    private static Predicate<String> getFilterRemove(String condition, String subStr) {
        switch (condition) {
            case "StartsWith":
                return w -> w.startsWith(subStr);
            case "EndsWith":
                return w -> w.endsWith(subStr);
            case "Length":
                return w -> w.length() == Integer.parseInt(subStr);
            default:
                throw new IllegalArgumentException("Unknown condition " + condition);
        }
    }
}
