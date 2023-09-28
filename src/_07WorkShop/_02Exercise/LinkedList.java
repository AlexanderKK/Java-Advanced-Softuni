package _07WorkShop._02Exercise;

import java.util.function.Consumer;

public class LinkedList {
    static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    private boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int element) {

        //Create Node
        Node newNode = new Node(element);

        if(!isEmpty()) {
            newNode.next = head;
        }

        //Set head to new Node
        head = newNode;

        //Increase Size
        size++;
    }

    public void addLast(int element) {
        if(isEmpty()) {
            addFirst(element);
            return;
        }

        Node currentNode = head;

        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(element);

        size++;
    }

    public int removeFirst() {
        if(isEmpty()) {
            throw new IllegalStateException("Can't remove from empty list!");
        }

        int removedElement = head.value;

        head = head.next;

        size--;

        return removedElement;
    }

    public int removeLast() {
        if(size < 2) {
            return removeFirst();
        }

        //Start node
        Node currentNode = head;

        //Until we reach element before last, go to next
        while(currentNode.next.next != null) {
            currentNode = currentNode.next;
        }

        //Save removed element
        int removedElement = currentNode.next.value;

        //Kill last node (remove last element)
        currentNode.next = null;

        size--;

        return removedElement;
    }

    public int get(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("No such index in the list");
        }

        int currentIndex = 0;
        Node currentNode = head;

        while(currentIndex < index) {
            currentIndex++;
            currentNode = currentNode.next;
        }

//        while(currentNode.next != null) {
//            currentNode = currentNode.next;
//            currentIndex++;
//
//            if(currentIndex == index) {
//                break;
//            }
//        }

        return currentNode.value;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = head;

        while(currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[size];

        int index = 0;
        Node currentNode = head;

        while(currentNode != null) {
            array[index++] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }
}
