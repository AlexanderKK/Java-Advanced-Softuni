package _08Generics._02Exercise._05GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    private void checkIndex(int index) {
        if(index < 0 || index >= values.size()) {
            throw new IndexOutOfBoundsException(String.format("Index %s out of bounds for length %d", index, values.size()));
        }
    }

    public Box() {
        values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public T get(int index) {
        checkIndex(index);

        return values.get(index);
    }

    public void swap(int index1, int index2) {
        checkIndex(index1);
        checkIndex(index2);
        T firstElement = values.get(index1);
        T secondElement = values.get(index2);

        values.set(index1, secondElement);
        values.set(index2, firstElement);

//        Collections.swap(values, index1, index2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        values.forEach(e -> sb.append(String.format("%s: %s%n", e.getClass().getName(), e)));

        return sb.toString();
    }

    public int getGreaterCount(T comparingElement) {
        int count = (int) values.stream()
                .filter(e -> e.compareTo(comparingElement) > 0)
                .count();

        return count;

//        int count = 0;
//        for (T value : values) {
//            if(value.compareTo(comparingElement) > 0) {
//                count++;
//            }
//        }
//
//        return count;
    }
}
