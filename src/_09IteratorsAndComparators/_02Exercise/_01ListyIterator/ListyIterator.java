package _09IteratorsAndComparators._02Exercise._01ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {
    private int index = 0;
    private class ListIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            if(index == size() - 1) {
                return false;
            }
            return index < size();
        }

        @Override
        public T next() {
            return elements.get(index);
        }
    }
    private final List<T> elements;

    @SafeVarargs
    public ListyIterator(T... elements) {
        this.elements = Arrays.asList(elements);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return elements.size();
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    public boolean move() {
        if(index < size() - 1) {
            index++;

            return true;
        }
        return false;
    }
}
