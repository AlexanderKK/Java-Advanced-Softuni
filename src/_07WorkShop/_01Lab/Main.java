package _07WorkShop._01Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> l = new ArrayList<>();

        long startL = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            l.add(i + 1);
        }

        long endL = System.currentTimeMillis();

        System.out.println("Regular list: " + (endL - startL) + " ms");

        SmartArray list = new SmartArray();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        long end = System.currentTimeMillis();

//        System.out.println(list.get(-1));
//        System.out.println(list.get(list.size()));

        System.out.println();
        System.out.println("Custom list: " + (end - start) + " ms");

        System.out.println(list.contains(3));
//        System.out.println(list.remove(2));
        System.out.println(list.contains(3));

        list.add(1, 10);

        list.remove(0);

        System.out.println();

        list.forEach(System.out::println);


        Stack stack = new Stack();
        stack.push(10);
        stack.push(11);
        stack.push(12);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.pop();

        System.out.println(stack.peek());

        stack.forEach(System.out::println);

        System.out.println();
    }
}
