package _09IteratorsAndComparators._02Exercise._03StackIterator;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private class StackIterator implements Iterator<T> {
        Node currentNode = head;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            Node current = currentNode;
            currentNode = currentNode.next;
            return current.value;
        }
    }

    class Node {
        private final T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    public void push(T element) {
        Node node = new Node(element);

        if(!isEmpty()) {
            node.next = head;
        }

        head = node;

        size++;
    }

    public Object pop() {
        Object result = head.value;

        head = head.next;
        size--;

        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
}
