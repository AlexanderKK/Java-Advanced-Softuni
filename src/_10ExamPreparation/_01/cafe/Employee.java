package _10ExamPreparation._01.cafe;

public class Employee {
    private String name;
    private int age;
    private String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = Math.max(age, 1);
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d from %s", name, age, country);
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public String country() {
        return country;
    }
}
