package main.java;

import java.util.Scanner;
import java.util.ArrayList;

public class ManageEmployees {

    public static void addNewEmployee(ArrayList<Employee> employees, Scanner scanner) {
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter position: ");
        String position = scanner.nextLine();
        System.out.println("Enter salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(employees.size(), firstName, lastName, position, salary);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public static void showAllEmployees(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("--------------------------------");
            employee.print();
            System.out.println("--------------------------------");
            System.out.println();
        }
    }

    public static void searchEmployeeByName(ArrayList<Employee> employees, Scanner scanner) {

    }

    public static void editEmployeeData(ArrayList<Employee> employees, Scanner scanner) {
        System.out.println("Enter employee ID (int): \nEnter -1 to show all employees");
        int id = scanner.nextInt();
        if (id == -1) {
            showAllEmployees(employees);
            System.out.println("Enter employee ID (int): ");
            id = scanner.nextInt();
        }

        Employee employee = employees.get(id);

        System.out.println("Enter employee first (String): \nEnter -1 to keep employee first name");
        String firstName = scanner.next();
        if (firstName.equals("-1")) {
            firstName = employee.getFirstName();
        }

        System.out.println("Enter employee last name (String): \nEnter -1 to keep employee last name");
        String lastName = scanner.next();
        if (lastName.equals("-1")) {
            lastName = employee.getLastName();
        }

        System.out.println("Enter employee position (String): \nEnter -1 to keep employee position");
        String position = scanner.next();
        if (position.equals("-1")) {
            position = employee.getPosition();
        }

        System.out.println("Enter employee salary (double): \nEnter -1 to keep employee salary");
        double salary = scanner.nextDouble();
        if (salary == -1) {
            salary = employee.getSalary();
        }

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPosition(position);
        employee.setSalary(salary);
        employees.set(id, employee);
        System.out.println("Employee edited successfully!");
    }
}
