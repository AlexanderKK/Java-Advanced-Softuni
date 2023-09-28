package _09IteratorsAndComparators._02Exercise._09LinkedListTraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
    private class LinkedListIterator implements Iterator<T> {
        Node<T> currentNode = head;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            //Get value of current Node
            T currentValue = currentNode.value;

            //Go to next Node
            currentNode = currentNode.next;

            return currentValue;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T element) {

        //Create Node
        Node<T> newNode = new Node<>(element);

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

    public void addLast(T element) {
        if(isEmpty()) {
            addFirst(element);
            return;
        }

        Node<T> newNode = new Node<>(element);

        newNode.prev = tail;
        tail.next = newNode;

        tail = newNode;

        size++;
    }

    public void add(T element) {
        if(isEmpty()) {
            addFirst(element);
            return;
        }

        Node<T> newNode = new Node<>(element);

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;

        size++;
    }

    public boolean remove(T element) {
        Node<T> currentNode = head;

        while(currentNode != null) {
            if(currentNode.value.compareTo(element) == 0) {
                if(size == 1) {
                    head = null;
                    tail = null;
                }

                Node<T> previousNode = currentNode.prev;
                Node<T> nextNode = currentNode.next;

                if(previousNode != null) {
                    previousNode.next = nextNode;
                }

                if(nextNode != null) {
                    nextNode.prev = previousNode;
                }

                if(previousNode == null) {
                    head = nextNode;
                }

                if(nextNode == null) {
                    tail = previousNode;
                }

                size--;

                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    public T removeFirst() {
        if(isEmpty()) {
            throw new IllegalStateException("Can't remove from empty list!");
        }

        T removedElement = head.value;

        head = head.next;
        head.prev = null;

        size--;

        if(isEmpty()) {
            tail = null;
        }

        return removedElement;
    }

    public T removeLast() {
        if(size < 2) {
            return removeFirst();
        }

        T removedElement = tail.value;

        tail = tail.prev;
        tail.next = null;

        size--;

        return removedElement;
    }

    public T get(int index) {
        checkIndex(index);

        Node<T> currentNode;
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

    public void forEach(Consumer<? super T> consumer) {
        Node<T> currentNode = head;

        while(currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public T[] toArray() {
        List<T> list = new ArrayList<>();
        forEach(list::add);

        return (T[]) list.stream().toArray();
    }
}
