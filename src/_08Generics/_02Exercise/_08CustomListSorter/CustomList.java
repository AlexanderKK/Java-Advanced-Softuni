package _08Generics._02Exercise._08CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> data;

    public CustomList() {
        data = new ArrayList<>();
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException(
                    String.format("Index %s out of bounds for length %d",
                    index, data.size())
            );
        }
    }

    public int size() {
        return data.size();
    }

    public void add(T element) {
        data.add(element);
    }

    public T remove(int index) {
        return data.remove(index);
    }

    public T get(int index) {
        checkIndex(index);

        return data.get(index);
    }

    public void set(int index, T element) {
        data.set(index, element);
    }

    public boolean contains(T element) {
        return data.contains(element);
    }

    public void swap(int index1, int index2) {
        Collections.swap(data, index1, index2);
    }

    public int countGreaterThan(T element) {
        int count = (int) data
                .stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();

        return count;
    }

    public T getMax() {
        T max = data.stream()
                .findFirst()
                .orElseThrow(IllegalStateException::new);

        for (T currentElement : data) {
            if(currentElement.compareTo(max) > 0) {
                max = currentElement;
            }
        }

        data.stream().max((f, s) -> f.compareTo(s)).get();
        data.stream().max(Comparable::compareTo).get();

        return max;
    }

    public T getMin() {
        return data.stream().min((f, s) -> f.compareTo(s)).get();

//        return Collections.min(data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        data.forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
