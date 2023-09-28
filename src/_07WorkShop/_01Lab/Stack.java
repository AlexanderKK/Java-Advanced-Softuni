package _07WorkShop._01Lab;

import java.util.function.Consumer;

public class Stack {
    static class Node {
        private int element;

        private Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public void push(int element) {
        Node node = new Node(element);

        node.prev = top;
        top = node;

        size++;
    }

    public int pop() {
        if(top == null) {
            throw new IllegalStateException("Stack is empty!");
        }

        int removedElement = top.element;
        top = top.prev;

        size--;

        return removedElement;
    }

    public int peek() {
        return top.element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = top;

        while(currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.prev;
        }
    }
}
