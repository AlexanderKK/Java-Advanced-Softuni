package _06DefiningClasses._02Exercise._02CompanyRoaster2;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;
    protected static List<Department> departments = new ArrayList<>();

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String name() {
        return this.name;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Highest Average Salary: " + name + "\n");
        employees.stream()
                .sorted((first, second) -> Double.compare(second.salary(), first.salary()))
                .forEach(obj -> result.append(obj).append("\n"));

        return result.toString();
    }

    public double calcAvgSalary() {
        return this.employees.stream().mapToDouble(Employee::salary).average().orElse(0);
    }
}
