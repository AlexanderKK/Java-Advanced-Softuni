package _06DefiningClasses._02Exercise._07Google;

public class Company {
    private String name;
    private String department;
    private double salary;

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + department + " " + String.format("%.2f", salary);
    }
}
