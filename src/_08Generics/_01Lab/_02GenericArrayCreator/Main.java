package _08Generics._01Lab._02GenericArrayCreator;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = ArrayCreator.<Integer>create(5, 13);

        Integer[] arr2 = ArrayCreator.<Integer>create(Integer.class, 5, 13);

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : arr2) {
            System.out.print(i + " ");
        }

        System.out.println();

        String[] strings = ArrayCreator.create(5, "Java-Generics");

        for (String string : strings) {
            System.out.print(string + " ");
        }
    }
}
