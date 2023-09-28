package _08Generics._01Lab._01JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Beans<Integer>> jar = new Jar<>();

        jar.add(new Beans<>(370));
        jar.add(new Beans<>(540));

        Beans<Integer> removedBeans = jar.remove();
        System.out.println(removedBeans + " has been eaten.");
    }
}
