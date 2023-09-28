package _09IteratorsAndComparators._02Exercise._08PetClinics2;

public class Pet {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", name, age, kind);
    }
}
