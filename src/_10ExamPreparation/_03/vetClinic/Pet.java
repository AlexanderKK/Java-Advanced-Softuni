package _10ExamPreparation._03.vetClinic;

public class Pet {
    private String name;
    private int age;
    private String owner;

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = Math.max(age, 1);
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", name, age, owner);
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public String owner() {
        return owner;
    }
}
