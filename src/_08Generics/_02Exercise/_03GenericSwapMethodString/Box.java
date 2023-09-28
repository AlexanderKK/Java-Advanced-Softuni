package _08Generics._02Exercise._03GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
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

    public void set(int index, T element) {
        checkIndex(index);

        values.set(index, element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        values.forEach(e -> {
            sb.append(String.format("%s: %s%n", e.getClass().getName(), e));
        });

        return sb.toString();
    }
}
