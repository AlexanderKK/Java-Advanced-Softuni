package _12IntroductionToAlgorithms;

import java.util.Scanner;

public class _02RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

//        Iterative Approach

//        int fact = 1;
//        while(n > 0) {
//            fact *= n--;
//        }
//        System.out.println(fact);

//        Recursive Approach

        int fact = calcFact(n);
        System.out.println(fact);
    }

    private static int calcFact(int n) {
        if(n == 1) {
            return 1;
        }

        int curFact = calcFact(n - 1);

//        System.out.println(n + " " + curFact);

        return n * curFact;
    }
}
