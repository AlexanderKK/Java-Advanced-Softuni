package _07WorkShop._02Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoubleLinkedList {
    static class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(int element) {

        //Create Node
        Node newNode = new Node(element);

        if(!isEmpty()) {
            head.prev = newNode;
            newNode.next = head;
        } else {
            tail = newNode;
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

        Node newNode = new Node(element);

        newNode.prev = tail;
        tail.next = newNode;

        tail = newNode;

        size++;
    }

    public int removeFirst() {
        if(isEmpty()) {
            throw new IllegalStateException("Can't remove from empty list!");
        }

        int removedElement = head.value;

        head = head.next;
        head.prev = null;

        size--;

        if(isEmpty()) {
            tail = null;
        }

        return removedElement;
    }

    public int removeLast() {
        if(size < 2) {
            return removeFirst();
        }

        int removedElement = tail.value;

        tail = tail.prev;
        tail.next = null;

        size--;

        return removedElement;
    }

    public int get(int index) {
        checkIndex(index);

        Node currentNode;
        if(index > size / 2) {
            currentNode = tail;

            int lastIndex = size - 1;
            while(lastIndex-- > index) {
                currentNode = currentNode.prev;
            }
        } else {
            int currentIndex = 0;
            currentNode = head;

            while(currentIndex < index) {
                currentIndex++;
                currentNode = currentNode.next;
            }
        }

        return currentNode.value;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("No such index in the list");
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = head;

        while(currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        List<Integer> list = new ArrayList<>();
        forEach(list::add);

        return list.stream().mapToInt(e -> e).toArray();
    }
}
