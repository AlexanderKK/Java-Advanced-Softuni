package _08Generics._02Exercise._02GenericBoxOfInteger;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box() {
        values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
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
