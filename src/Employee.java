package main.java;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String position;
    private double salary;

    public Employee(int id, String firstName, String lastName, String position, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return (firstName + " " + lastName);
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void print() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee First Name: " + firstName);
        System.out.println("Employee Last Name: " + lastName);
        System.out.println("Employee Position: " + position);
        System.out.println("Employee Salary: " + salary);
    }
}
