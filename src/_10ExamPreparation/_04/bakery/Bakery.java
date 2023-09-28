package _10ExamPreparation._04.bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public int getCount() {
        return employees.size();
    }

    public void add(Employee employee) {
        if(getCount() < capacity) {
            boolean isEmployeePresent = employees.stream().anyMatch(e -> e.getName().equals(employee.getName()));

            if(!isEmployeePresent) {
                employees.add(employee);
            }
        }
    }

    public boolean remove(String name) {
//        return employees.removeIf(e -> e.getName().equals(name));
        boolean removed = false;
        Iterator<Employee> it = employees.iterator();
        while(it.hasNext()) {
            if(it.next().getName().equals(name)) {
                it.remove();
                removed =  true;
            }
        }

        return removed;
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employees working at Bakery %s:", name));
        sb.append(System.lineSeparator());

        employees.forEach(e -> sb.append(e).append(System.lineSeparator()));

        return sb.toString();
    }
}
