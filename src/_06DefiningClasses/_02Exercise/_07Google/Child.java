package _06DefiningClasses._02Exercise._07Google;

public class Child {
    private String name;
    private String birthDate;

    public Child(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + " " + birthDate;
    }
}
