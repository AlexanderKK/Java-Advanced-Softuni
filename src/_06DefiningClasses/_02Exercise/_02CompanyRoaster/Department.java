package _06DefiningClasses._02Exercise._02CompanyRoaster;

import java.util.*;
import java.util.stream.Collectors;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double calcAvgSalary() {
        return this.employees.stream().mapToDouble(Employee::salary).average().orElse(0);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Highest Average Salary: " + name + "\n");
        employees.stream()
                .sorted((first, second) -> Double.compare(second.salary(), first.salary()))
                .forEach(obj -> result.append(obj).append("\n"));

        return result.toString();
    }

    //    public static String bestDepartment() {
//        return departmentSalaries.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .orElse(null).getKey();
//    }
//
//    public static void printBestDepartment() {
//        System.out.println("Highest Average Salary: " + bestDepartment());
//
//        employees.stream()
//                .filter(e -> e.department().equals(bestDepartment()))
//                .sorted(Comparator.comparing(Employee::salary).reversed())
//                .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.name(), e.salary(), e.email(), e.age()));
//    }
}
