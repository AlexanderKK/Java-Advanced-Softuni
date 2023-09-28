package _05FunctionalProgramming._02Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Read names
        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String command;
        while(!"Print".equals(command = scanner.nextLine())) {
            String[] commandParts = command.split(";");

        //Read filters but remove deleted filters
            String addOrRemove = commandParts[0];
            String type = commandParts[1];
            String parameter = commandParts[2];

            if(addOrRemove.equals("Add filter")) {
                filters.add(type + ";" + parameter);
            } else {
                filters.remove(type + ";" + parameter);
            }
        }

        //apply filters to names
        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);

            guests.removeIf(filterToApply);
        });

        //print
        System.out.println(
                guests.stream()
                .collect(Collectors.joining(" "))
        );
    }

    private static Predicate<String> getPredicate(String filter) {
        String[] filterParts = filter.split(";");
        String filterType = filterParts[0];
        String parameter = filterParts[1];

        switch(filterType) {
            case "Starts with":
                return s -> s.startsWith(parameter);
            case "Ends with":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
            case "Contains":
                return s -> s.contains(parameter);
            default:
                throw new IllegalArgumentException("Unknown filter type " + filterType);
        }
    }
}
