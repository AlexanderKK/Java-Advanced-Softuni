package _11Exam._01TempleOfDoom;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //1. Read tools, substances and challenges
        //2. Take first tool and last substance and multiply them
        //3. If result exist it challenges -> remove from every collection
        //4. If there are no more tools or substances end program
        //5. If there are more challenges Harry is lost, otherwise Harry has found an ostracon

        ArrayDeque<Integer> tools = fillDeque("queue");

        ArrayDeque<Integer> substances = fillDeque("stack");

        ArrayDeque<Integer> challenges = fillDeque("queue");

        while(!tools.isEmpty() && !substances.isEmpty()) {
            int tool = tools.peek();
            int substance = substances.peek();

            int result = tool * substance;
            int challenge = challenges.stream().filter(e -> e == result).findFirst().orElse(0);

            tools.poll();
            substances.pop();

            if(challenge != 0) {
                challenges.remove(result);
            } else {
                tools.add(++tool);

                if(--substance != 0) {
                    substances.push(substance);
                }
            }
        }

        printRemains(tools, substances, challenges);
    }

    private static void printRemains(ArrayDeque<Integer> tools, ArrayDeque<Integer> substances, ArrayDeque<Integer> challenges) {
        if(challenges.isEmpty()) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        } else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        }

        printData("Tools: ", tools);
        printData("Substances: ", substances);
        printData("Challenges: ", challenges);
    }

    private static void printData(String prefix, ArrayDeque<Integer> deque) {
        if(!deque.isEmpty()) {
            System.out.println(prefix + deque.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }

    private static ArrayDeque<Integer> fillDeque(String type) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(type.equals("stack") ? deque::push : deque::offer);

        return deque;
    }
}
