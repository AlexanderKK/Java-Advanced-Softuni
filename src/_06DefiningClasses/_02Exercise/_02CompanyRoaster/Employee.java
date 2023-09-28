package _06DefiningClasses._02Exercise._02CompanyRoaster;

public class Employee {
    //salary, position, department, email, and age
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }

    public String name() {
        return name;
    }

    public double salary() {
        return salary;
    }

    public String department() {
        return department;
    }

    public String email() {
        return email;
    }

    public int age() {
        return age;
    }
}
