package _10ExamPreparation._02._01DatingApp;

import java.security.PrivateKey;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(maleStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(femaleQueue::offer);

        int matches = 0;

        while(!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int male = maleStack.peek();
            int female = femaleQueue.peek();

            //If male is divisible by 25 remove this and next male
            if(male % 25 == 0 && male != 0) {
                for (int i = 0; i < 2; i++) {
                    if(!maleStack.isEmpty()) {
                        maleStack.pop();
                    }
                }

                continue;
            }

            //If female is divisible by 25 remove this and next female
            if(female % 25 == 0 && female != 0) {
                for (int i = 0; i < 2; i++) {
                    if(!femaleQueue.isEmpty()) {
                        femaleQueue.pop();
                    }
                }

                continue;
            }

            if(male <= 0) {
                maleStack.pop();

                continue;
            }

            if(female <= 0) {
                femaleQueue.poll();

                continue;
            }

            if(male == female) {
                matches++;

                maleStack.pop();
                femaleQueue.poll();
            } else {
                male -= 2;

                maleStack.pop();

                maleStack.push(male);

                femaleQueue.poll();
            }
        }

        System.out.println("Matches: " + matches);

        System.out.println(printPeopleLeft(maleStack, "Males left: "));
        System.out.println(printPeopleLeft(femaleQueue, "Females left: "));
    }

    private static String printPeopleLeft(ArrayDeque<Integer> deque, String prefix) {
        String result = prefix;

        if(deque.isEmpty()) {
            result += "none";
        } else {
            result += deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
        }

        return result;
    }
}
