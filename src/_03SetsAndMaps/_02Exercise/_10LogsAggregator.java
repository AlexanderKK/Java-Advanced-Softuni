package _03SetsAndMaps._02Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> userIPsMap = new TreeMap<>();
        Map<String, Integer> userDurationMap = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        if(n >= 1 && n <= 1000) {
            while(n-- > 0) {
                String[] input = scanner.nextLine().split(" ");

                String IP = input[0];
                String user = input[1];
                int duration = Integer.parseInt(input[2]);

                //Check if input data is valid
                if(isInputValid(IP, user, duration)) {
                    //Add IP to userIPsMap
                    userIPsMap.putIfAbsent(user, new TreeSet<>());
                    userIPsMap.get(user).add(IP);

                    //Add duration to userDurationMap
                    userDurationMap.putIfAbsent(user, 0);
                    userDurationMap.put(user, userDurationMap.get(user) + duration);
                }
            }

            printUserData(userIPsMap, userDurationMap);
        }
    }

    private static void printUserData(Map<String, Set<String>> userIPsMap, Map<String, Integer> userDurationMap) {
        userDurationMap.forEach((user, duration) -> {
            System.out.printf("%s: %d [%s]%n", user, duration, String.join(", ", userIPsMap.get(user)));
        });
    }

    private static boolean isInputValid(String IP, String user, int duration) {
        String regexIPv4 = "((?<portion>25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(?<separator>\\.|$)){4}";
        Pattern patternIPv4 = Pattern.compile(regexIPv4);
        Matcher matcherIPv4 = patternIPv4.matcher(IP);

        return matcherIPv4.find() && Pattern.compile("[A-Za-z]{1,20}").matcher(user).find() && duration >= 1 && duration <= 1000;
    }
}
