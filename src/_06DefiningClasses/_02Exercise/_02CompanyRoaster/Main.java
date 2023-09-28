package _06DefiningClasses._02Exercise._02CompanyRoaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Department> departments = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String employeeDepartment = data[3];

            Employee employee = null;

            if(data.length == 6) {
                String email = data[4];
                int age = Integer.parseInt(data[5]);

                employee = new Employee(name, salary, position, employeeDepartment, email, age);
            } else if(data.length == 5 && isInteger(data[4])) {
                int age = Integer.parseInt(data[4]);

                employee = new Employee(name, salary, position, employeeDepartment, age);
            } else if(data.length == 5 && !isInteger(data[4])) {
                String email = data[4];

                employee = new Employee(name, salary, position, employeeDepartment, email);
            } else {
                employee = new Employee(name, salary, position, employeeDepartment);
            }

            //Check if department exists in departments list
            boolean departmentExists = departments.stream().anyMatch(d -> d.getName().equals(data[3]));
            if(!departmentExists) {
                //If not -> create new department and add to department list
                Department department = new Department(employeeDepartment);
                departments.add(department);
            }

            //Get current department
            Department currentDepartment = departments.stream()
                    .filter(dep -> dep.getName().equals(employeeDepartment))
                    .findFirst()
                    .get();

            //Add employee to department ArrayList employees
            currentDepartment.getEmployees().add(employee);
        }

        Department highestPaidDepartment = departments
                .stream()
                .max((first, second) -> Double.compare(first.calcAvgSalary(), second.calcAvgSalary()))
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
