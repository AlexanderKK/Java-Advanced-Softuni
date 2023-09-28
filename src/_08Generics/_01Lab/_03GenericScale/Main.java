package _08Generics._01Lab._03GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> scaleStrings = new Scale<>("a", "c");
        System.out.println(scaleStrings.getHeavier());

        Scale<Integer> scaleIntegers = new Scale<>(2, 2);
        System.out.println(scaleIntegers.getHeavier());
    }
}
