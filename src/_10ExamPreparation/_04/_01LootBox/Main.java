package _10ExamPreparation._04._01LootBox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Read Integers and add to queue
        //Read Integers and add to stack

        ArrayDeque<Integer> queueBox = fillBox("queue");
        ArrayDeque<Integer> stackBox = fillBox("stack");

        int claimedLoot = 0;
        //While one of boxes !isEmpty sum first value from queue and last from stack
        while(!queueBox.isEmpty() && !stackBox.isEmpty()) {
            int firstBoxValue = queueBox.peek();
            int secondBoxValue = stackBox.peek();

            //if firstValue + secondValue % 2 == 0 -> add sum to claimed loot and remove both values
            //else remove secondValue and add it to firstBox
            int sumValues = firstBoxValue + secondBoxValue;

            if(sumValues % 2 == 0) {
                claimedLoot += sumValues;
                queueBox.poll();
                stackBox.pop();
            } else {
                queueBox.offer(stackBox.pop());
            }
        }

        printClaimedLoot(queueBox, stackBox, claimedLoot);
    }

    private static void printClaimedLoot(ArrayDeque<Integer> queueBox, ArrayDeque<Integer> stackBox, int claimedLoot) {
        if(queueBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if(stackBox.isEmpty()){
            System.out.println("Second lootbox is empty");
        }

        System.out.println(claimedLoot >= 100 ? ("Your loot was epic! Value: " + claimedLoot)
                                              : ("Your loot was poor... Value: " + claimedLoot));
    }

    private static ArrayDeque<Integer> fillBox(String type) {
        ArrayDeque<Integer> box = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(type.equals("stack") ? box::push : box::add);

        return box;
    }
}
