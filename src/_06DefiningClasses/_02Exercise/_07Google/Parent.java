package _06DefiningClasses._02Exercise._07Google;

public class Parent {
    private String name;
    private String birthDate;

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Parent(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + " " + birthDate;
    }
}
