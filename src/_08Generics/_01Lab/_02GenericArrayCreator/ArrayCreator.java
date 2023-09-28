package _08Generics._01Lab._02GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {
    public static <Type> Type[] create(int length, Type defaultValue) {
        return create(defaultValue.getClass(), length, defaultValue);
    }

    public static <Type> Type[] create(Class<?> clazz, int length, Type defaultValue) {
        Type[] arr = (Type[]) Array.newInstance(clazz, length);

        Arrays.fill(arr, defaultValue);
        return arr;
    }
}
