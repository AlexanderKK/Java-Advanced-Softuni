package _06DefiningClasses._02Exercise._02CompanyRoaster2;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String employeeDepartment = input[3];

            Employee employee = null;
            if(input.length == 4) {
                employee = new Employee(name, salary, position, employeeDepartment);
            } else if(input.length == 5 && !isInteger(input[4])) {
                employee = new Employee(name, salary, position, employeeDepartment, input[4]);
            } else if(input.length == 5 && isInteger(input[4])) {
                employee = new Employee(name, salary, position, employeeDepartment, Integer.parseInt(input[4]));
            } else {
                employee = new Employee(name, salary, position, employeeDepartment, input[4], Integer.parseInt(input[5]));
            }

            boolean depExists = Department.departments
                    .stream()
                    .anyMatch(d -> d.name().equals(employeeDepartment));

            if(!depExists) {
                Department department = new Department(employeeDepartment);
                Department.departments.add(department);
            }

            Department currentDepartment = Department.departments
                    .stream()
                    .filter(d -> d.name().equals(employeeDepartment))
                    .findFirst()
                    .get();

            currentDepartment.getEmployees().add(employee);
        }

        Department highestPaidDepartment = Department.departments
                .stream()
                .max(Comparator.comparingDouble(Department::calcAvgSalary))
                .get();

        System.out.println(highestPaidDepartment);
    }

    private static boolean isInteger(String str) {
        for (char c : str.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
