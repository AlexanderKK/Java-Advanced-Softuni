package _10ExamPreparation._03._01OSPlanning;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(taskStack::push);

        ArrayDeque<Integer> threadQueue = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int task = Integer.parseInt(scanner.nextLine());

        while(!taskStack.isEmpty() && task != taskStack.peek()) {
            int curTask = taskStack.peek();
            int curThread = threadQueue.peek();

            if(curThread >= curTask) {
                taskStack.pop();
            }

            threadQueue.poll();
        }

        System.out.printf("Thread with value %d killed task %d%n", threadQueue.peek(), taskStack.peek());
        System.out.println(threadQueue.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
