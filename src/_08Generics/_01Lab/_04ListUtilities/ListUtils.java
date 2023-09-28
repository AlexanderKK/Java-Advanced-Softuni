package _08Generics._01Lab._04ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {
    private static <T> void isEmpty(List<T> list) {
        if(list.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        }
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        isEmpty(list);

        T max = Collections.max(list);
        return max;
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        isEmpty(list);

        return Collections.min(list);
    }
}
