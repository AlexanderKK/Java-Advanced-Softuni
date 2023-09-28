package _09IteratorsAndComparators._02Exercise._02Collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commandParts = scanner.nextLine().split("\\s+");

        String[] elements = new String[commandParts.length - 1];

        if(elements.length > 0) {
            System.arraycopy(commandParts, 1, elements, 0, commandParts.length - 1);
        }

        ListyIterator<String> list = new ListyIterator<>(elements);

        int counter = 1;

        String command;
        while(!"END".equals(command = scanner.nextLine())) {
            if(counter > 100) {
                break;
            }

            String cmd = command.split("\\s+")[0];

            if("Move".equals(cmd)) {
                System.out.println(list.move());
            } else if("HasNext".equals(cmd)) {
                System.out.println(list.iterator().hasNext());
            } else if("Print".equals(cmd)) {
                if(!list.isEmpty()) {
                    System.out.println(list.iterator().next());
                } else {
                    System.out.println("Invalid Operation!");
                }
            } else if("PrintAll".equals(cmd)) {
                list.printAll();
            }

            counter++;
        }
    }
}
