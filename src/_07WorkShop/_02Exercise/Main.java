package _07WorkShop._02Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        1. Linked List With Head

//        LinkedList list = new LinkedList();
//
//        list.addLast(13);
//        list.addLast(42);
//        list.addLast(69);
//        list.addLast(45);
//        list.addLast(12);
//
//        list.removeFirst();
//
//        list.removeLast();
//        list.removeLast();
//
//        list.forEach(System.out::println);
//
//        int[] listToArr = list.toArray();
//
//        System.out.printf("[%s]", Arrays.stream(listToArr).mapToObj(String::valueOf).collect(Collectors.joining(", ")));


//        2. Linked List With Head & Tail

//        LinkedListTail list = new LinkedListTail();
//        list.addFirst(10);
//
//        list.addLast(23);
//        list.removeLast();
//        list.removeLast();


//        3. Double Linked List with prev and next

        DoubleLinkedList list = new DoubleLinkedList();
//        list.addFirst(13);
//        list.addFirst(42);
//        list.addFirst(69);
//
//        list.addLast(77);
//
//        list.removeFirst();
//
//        list.removeLast();
//
//        list.addLast(80);
//
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.forEach(e -> System.out.print(e + " "));

        System.out.println();
        System.out.println(list.get(0));
        System.out.println(list.get(list.size() - 2));

        System.out.println(list.removeLast());
    }
}
