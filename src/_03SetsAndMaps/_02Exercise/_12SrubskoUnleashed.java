package _03SetsAndMaps._02Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _12SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> srubsko = new LinkedHashMap<>();

        String regex = "\\b(?<singer>[A-Za-z]+|[A-Za-z]+\\s[A-Za-z]+|[A-Za-z]+\\s[A-Za-z]+\\s[A-Za-z]+) @(?<venue>[A-Za-z]+|[A-Za-z]+\\s[A-Za-z]+|[A-Za-z]+\\s[A-Za-z]+\\s[A-Za-z]+) (?<price>200|1[0-9][0-9]|[0-9]{1,2}) (?<tickets>100000|0|[1-9]\\d{0,4})\\b";
        Pattern pattern = Pattern.compile(regex);

        int inputCount = 0;

        String input;
        while(!"End".equals(input = scanner.nextLine())) {
            inputCount++;
            if(inputCount > 50) {
                return;
            }

            Matcher matcher = pattern.matcher(input);
            if(matcher.find()) {
                String singer = input.substring(0, input.indexOf("@") - 1);

                int venueEndIndex = getVenueEndIndex(input);
                String venue = input.substring(input.indexOf("@") + 1, venueEndIndex);

                String[] inputArr = input.split(" ");
                int price = Integer.parseInt(inputArr[inputArr.length - 2]);
                int tickets = Integer.parseInt(inputArr[inputArr.length - 1]);

                long profit = (long) price * tickets;

                //Write data to Map
                srubsko.putIfAbsent(venue, new LinkedHashMap<>());   //Add venue key
                srubsko.get(venue).putIfAbsent(singer, 0L);   //Add singer and initial profit
                srubsko.get(venue).put(singer, srubsko.get(venue).get(singer) + profit);   //Add profit to current singer
            }
        }

        //Print data from map
        printRakia(srubsko);
    }

    private static void printRakia(Map<String, LinkedHashMap<String, Long>> srubsko) {
        srubsko.forEach((venue, singers) -> {
            System.out.println(venue);

            LinkedHashMap<String, Long> singersSorted = singers.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            singersSorted.forEach((singer, profit) -> System.out.printf("#  %s -> %d%n", singer, profit));
        });
    }

    private static int getVenueEndIndex(String input) {
        int venueEndIndex = -1;
        for (char c : input.toCharArray()) {
            if(Character.isDigit(c)) {
                venueEndIndex += input.indexOf(c);
                break;
            }
        }
        return venueEndIndex;
    }
}
