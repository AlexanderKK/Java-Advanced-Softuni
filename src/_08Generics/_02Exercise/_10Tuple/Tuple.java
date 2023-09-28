package _08Generics._02Exercise._10Tuple;

public class Tuple<F, S> {
    private final F first;
    private final S second;

    public Tuple(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F first() {
        return first;
    }

    public S second() {
        return second;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", first, second);
    }
}
