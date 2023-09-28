package _05FunctionalProgramming._02Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11ThePartyReservationFilterModule2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String input;
        while(!"Print".equals(input = scanner.nextLine())) {
            String cmd = input.substring(0, input.indexOf(";"));
            String filterModule = input.substring(input.indexOf(";") + 1);

            if(cmd.equals("Add filter")) {
                filters.add(filterModule);
            } else if(cmd.equals("Remove filter")) {
                filters.remove(filterModule);
            }
        }

        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);
            guests.removeIf(filterToApply);
        });

        System.out.println(guests.stream().collect(Collectors.joining(" ")));
    }

    private static Predicate<String> getPredicate(String filter) {
        String filterType = filter.split(";")[0];
        String filterParameter = filter.split(";")[1];

        switch (filterType) {
            case "Starts with":
                return guestName -> guestName.startsWith(filterParameter);
            case "Ends with":
                return guestName -> guestName.endsWith(filterParameter);
            case "Length":
                return guestName -> guestName.length() == Integer.parseInt(filterParameter);
            case "Contains":
                return guestName -> guestName.contains(filterParameter);
            default:
                throw new IllegalArgumentException("Unknown filter module");
        }
    }
}
