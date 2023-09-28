package _01StacksAndQueues._01Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04MatchingBrackets2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<Integer> openingBracketsIndices = new ArrayDeque<>();

        for (int index = 0; index < expression.length(); index++) {
            if(expression.charAt(index) == '(') {
                openingBracketsIndices.push(index);
            } else if(expression.charAt(index) == ')') {
                int startIndex = openingBracketsIndices.pop();
                int endIndex = index + 1;

                String subExpression = expression.substring(startIndex, endIndex);
                System.out.println(subExpression);
            }
        }
    }
}
