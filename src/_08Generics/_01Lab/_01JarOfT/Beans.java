package _08Generics._01Lab._01JarOfT;

public class Beans<T> {
    private int qtyGrams;

    public Beans(int qty) {
        qtyGrams = qty;
    }

    @Override
    public String toString() {
        return qtyGrams + " grams of beans";
    }
}
