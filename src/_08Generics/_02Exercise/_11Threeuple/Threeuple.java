package _08Generics._02Exercise._11Threeuple;

/**
 * @param <F> first element
 * @param <S> second element
 * @param <T> third element
 */
public class Threeuple<F, S, T> {
    private final F first;
    private final S second;
    private final T third;

    public Threeuple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public F first() {
        return first;
    }

    public S second() {
        return second;
    }

    public T third() {
        return third;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", first, second, third);
    }
}
