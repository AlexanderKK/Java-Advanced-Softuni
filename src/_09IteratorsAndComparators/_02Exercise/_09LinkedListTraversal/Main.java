package _09IteratorsAndComparators._02Exercise._09LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] cmdParts = scanner.nextLine().split(" ");

            String cmd = cmdParts[0];
            int number = Integer.parseInt(cmdParts[1]);

            if(cmd.equals("Add")) {
                list.add(number);
            } else if(cmd.equals("Remove")) {
                list.remove(number);
            }
        }

        System.out.println(list.size());

        for (Integer number : list) {
            System.out.print(number + " ");
        }
    }
}
