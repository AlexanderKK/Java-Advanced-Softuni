package _08Generics._02Exercise._09CustomListIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String command;
        while(!"END".equals(command = scanner.nextLine())) {
            String[] commandParts = command.split("\\s+");

            String cmd = commandParts[0];

            switch(cmd) {
                case "Add":
                    String elementToAdd = commandParts[1];
                    list.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commandParts[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    String elementToCheck = commandParts[1];
                    System.out.println(list.contains(elementToCheck));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(commandParts[1]);
                    int secondIndex = Integer.parseInt(commandParts[2]);
                    list.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String element = commandParts[1];
                    System.out.println(list.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                case "Print":
                    System.out.println(list);
                    break;
            }
        }
    }
}
