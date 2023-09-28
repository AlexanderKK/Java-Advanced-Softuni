package _10ExamPreparation._01.cafe;

import java.util.*;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>(capacity);
    }

    public void addEmployee(Employee employee) {
        boolean isEmployeePresent = employees.stream().anyMatch(e -> e.name().equals(employee.name()));

        if(getCount() < capacity && !isEmployeePresent) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        boolean isEmployeePresent = employees.stream().anyMatch(e -> e.name().equals(name));

        if(isEmployeePresent) {
            Employee currentEmployee = employees.stream().filter(e -> e.name().equals(name)).findFirst().get();

            employees.remove(currentEmployee);

            return true;
        }

        return false;
    }

    public Employee getOldestEmployee() {
        List<Integer> ages = new ArrayList<>();

        employees.forEach(e -> ages.add(e.age()));

        int minAge = ages.stream().max(Comparator.comparingInt(e -> e)).orElse(1);

        Employee oldestEmployee = employees.stream().filter(e -> e.age() == minAge).findFirst().get();

        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.name().equals(name)).findFirst().get();
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Employees working at Cafe %s:%n", name));

        employees.forEach(e -> sb.append(e).append(System.lineSeparator()));

        return sb.toString();
    }
}
