package _10ExamPreparation._01._01SantasPresentFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.
        //Declare materials Stack
        //Declare magic level Queue

        //2.
        //Declare a Map<String, Integer>> for presents you are going to craft

        //2.
        //Pop material value from Stack
        //Poll magic value from Queue

        //3.
        //Multiply material value with magic value

        //4.
        //If result equals one of the magic levels from table -> craft a present and remove both values
        //If result is negative sum values together, remove them and add result to materials
        //If result is positive and not equal to a magic level from table remove only magic value and increase material value by 15
        //If the magic or material (or both) equals 0, remove it (or both) and continue crafting the presents

        //5.
        //Stop crafting presents when you run out of boxes of materials or magic level values.

        Map<String, Integer> magicTable = Map.of(
                "Doll", 150,
                "Wooden train",250,
                "Teddy bear", 300,
                "Bicycle", 400
        );

        Map<String, Integer> presents = new TreeMap<>();

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicValuesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materialsStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(magicValuesQueue::offer);

        while(!materialsStack.isEmpty() && !magicValuesQueue.isEmpty()) {
            int materialValue = materialsStack.pop();
            int magicValue = magicValuesQueue.poll();

            int result = materialValue * magicValue;
            boolean canBeCrafted = magicTable.entrySet().stream().anyMatch(e -> e.getValue() == result);

            if(canBeCrafted) {
                magicTable.entrySet().stream()
                        .filter(e -> e.getValue() == result)
                        .forEach(e -> {
                            presents.putIfAbsent(e.getKey(), 0);

                            String currentPresent = e.getKey();

                            presents.put(currentPresent, presents.get(currentPresent) + 1);
                        });
            } else if(result < 0) {
                int sum = materialValue + magicValue;
                materialsStack.push(sum);
            } else if(result > 0) {
                materialValue += 15;
                materialsStack.push(materialValue);
            } else {
                if(materialValue != 0) {
                    materialsStack.push(materialValue);
                }

                if(magicValue != 0) {
                    magicValuesQueue.addFirst(magicValue);
                }
            }
        }

        boolean isTaskDone = (presents.containsKey("Doll") && presents.containsKey("Train")) ||
                             (presents.containsKey("Teddy bear") && presents.containsKey("Bicycle"));

        if(isTaskDone) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        printMaterials(materialsStack, "Materials left: ");

        printMaterials(magicValuesQueue, "Magic left: ");

        presents.forEach((present, count) -> System.out.printf("%s: %d%n", present, count));
    }

    private static void printMaterials(ArrayDeque<Integer> materialsOrMagic, String prefix) {
        if(!materialsOrMagic.isEmpty()) {
            StringBuilder sb = new StringBuilder();

            sb.append(prefix);

            sb.append(materialsOrMagic.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));

            System.out.println(sb);
        }
    }
}
