package main.java;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageGuests {

    public static void addNewGuest(ArrayList<Guest> guests, Scanner scanner) {
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        Guest guest = new Guest(guests.size(), firstName, lastName, email);
        guests.add(guest);
        System.out.println("Guest added successfully!");
    }

    public static void showAllGuests(ArrayList<Guest> guests) {
        for (Guest guest : guests) {
            System.out.println("--------------------------------");
            guest.print();
            System.out.println("--------------------------------");
            System.out.println();
        }
    }

    public static void searchGuestByName(ArrayList<Guest> guests, Scanner scanner) {
        System.out.println("Enter guest first name: ");
        String firstName = scanner.next();
        System.out.println("Enter guest last name: ");
        String lastName = scanner.next();
        System.out.println();

        for (Guest guest : guests) {
            if (guest.getName().equals(firstName + " " + lastName)) {
                guest.print();
                System.out.println();
            }
        }
    }

    public static void editGuest(ArrayList<Guest> guests, Scanner scanner) {
        System.out.println("Enter ID (int): \nEnter -1 to search guest by name");
        int id = scanner.nextInt();
        if (id == -1) {
            searchGuestByName(guests, scanner);
            System.out.println("Enter ID (int): ");
            id = scanner.nextInt();
        }
        Guest guest = guests.get(id);

        System.out.println("Enter guest's first name: \nEnter -1 to keep the guest's first name");
        String firstName = scanner.next();
        if (firstName.equals("-1")) {
            firstName = guest.getFirstName();
        }

        System.out.println("Enter guest's last name: \nEnter -1 to keep the guest's last name");
        String lastName = scanner.next();
        if (lastName.equals("-1")) {
            lastName = guest.getLastName();
        }

        System.out.println("Enter email: \nEnter -1 to keep the guest's email");
        String email = scanner.next();
        if (email.equals("-1")) {
            email = guest.getEmail();
        }

        guest.setFirstName(firstName);
        guest.setLastName(lastName);
        guest.setEmail(email);
        guests.set(id, guest);

    }
}
