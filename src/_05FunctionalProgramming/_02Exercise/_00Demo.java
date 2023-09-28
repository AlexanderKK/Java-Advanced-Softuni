package _05FunctionalProgramming._02Exercise;

public class _00Demo {
    public static void main(String[] args) {
        Converter converter = text -> text + " bye";

        System.out.println(converter.transformString("Mike"));

        TriFunction<String, Integer, Double, String> triFunction = (first, second, third) -> first + (second + third);
        System.out.println(triFunction.triFunction("Hello ", 10, 16.6));

        System.out.println(parseInt("10"));
    }

    private static Integer parseInt(String text) {
        return Integer.parseInt(text);
    }
}
