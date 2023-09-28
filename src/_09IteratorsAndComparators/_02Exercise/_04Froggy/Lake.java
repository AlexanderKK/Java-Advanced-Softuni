package _09IteratorsAndComparators._02Exercise._04Froggy;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake<T> implements Iterable<T> {
    private int index;
    private class Frog implements Iterator<T> {
        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            while (hasNext()) {
                action.accept(next());
            }
        }

        @Override
        public boolean hasNext() {
            if(index >= size() && index % 2 == 0) {
                index = 1;
            }

            return index < size();
        }

        @Override
        public T next() {

            T current = elements.get(index);
            index += 2;

            return current;
        }
    }
    private final List<T> elements;

    public Lake(List<T> elements) {
        this.elements = elements;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return elements.size();
    }

    public Iterator<T> iterator() {
        return new Frog();
    }
}
