package main.java;

public class Guest {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Guest(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Guest() {
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

    public String getEmail() {
        return email;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void print() {
        System.out.println("Guest ID: " + id);
        System.out.println("Guest First Name: " + firstName);
        System.out.println("Guest Last Name: " + lastName);
        System.out.println("Guest Email: " + email);

    }
}
