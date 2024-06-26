package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Room> rooms;
    private static ArrayList<Guest> guests;
    private static ArrayList<Employee> employees;
    private static ArrayList<Reservation> reservations;

    public static void main(String[] args) {

        rooms = new ArrayList<>();
        guests = new ArrayList<>();
        employees = new ArrayList<>();
        reservations = new ArrayList<>();

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("Hotel Pochacco Management System");
            displayAsciiArt("pochacco_ascii.txt");
            System.out.println("1. Rooms\n" +
                    "2. Guests\n" +
                    "3. Reservations\n" +
                    "4. Employees\n" +
                    "0. Quit");
            System.out.println();
            System.out.println("Enter your selection: ");
            int selection1 = scanner.nextInt();

            switch (selection1) {
                case 1:
                    // show room options
                    System.out.println("\nRoom Options");
                    System.out.println("1. Add new room\n" +
                            "2. Show all rooms\n" +
                            "3. Edit room data\n" +
                            "0. Quit");
                    System.out.println();
                    System.out.println("Enter your selection: ");
                    int selection2 = scanner.nextInt();

                    switch (selection2) {
                        case 1:
                            System.out.println("\nYou selected: Add new room");
                            ManageRooms.addNewRoom(rooms, scanner);
                            break;
                        case 2:
                            System.out.println("\nYou selected: Show all rooms");
                            ManageRooms.showAllRooms(rooms);
                            break;
                        case 3:
                            System.out.println("\nYou selected: Edit room data");
                            ManageRooms.editRoom(rooms, scanner);
                            break;
                        case 0:
                            System.out.println("\nYou selected: Quit");
                            break;
                        default:
                            System.out.println("\nInvalid selection. Please try again.");
                            break;
                    }

                    break;
                case 2:
                    // show guest options
                    System.out.println("\nGuest Options");
                    System.out.println("1. Add new guest\n" +
                            "2. Show all guests\n" +
                            "3. Search guest by name\n" +
                            "4. Edit guest data");
                    System.out.println();
                    System.out.println("Enter your selection: ");
                    selection2 = scanner.nextInt();

                    switch (selection2) {
                        case 1:
                            System.out.println("\nYou selected: Add new guest");
                            ManageGuests.addNewGuest(guests, scanner);
                            break;
                        case 2:
                            System.out.println("\nYou selected: Show all guests");
                            ManageGuests.showAllGuests(guests);
                            break;
                        case 3:
                            System.out.println("\nYou selected: Search guest by name");
                            ManageGuests.searchGuestByName(guests, scanner);
                            break;
                        case 4:
                            System.out.println("\nYou selected: Edit guest data");
                            ManageGuests.editGuest(guests, scanner);
                            break;
                        case 0:
                            System.out.println("\nYou selected: Quit");
                            break;
                        default:
                            System.out.println("\nInvalid selection. Please try again.");
                            break;
                    }

                    break;
                case 3:
                    // show reservation options
                    System.out.println("\nReservation Options");
                    System.out.println("1. Create new reservation\n" +
                            "2. Show all reservations\n" +
                            "3. Get reservation by guest name\n" +
                            "4. Get reservation by guest ID\n" +
                            "5. Edit reservation\n" +
                            "6. Pay reservation");
                    System.out.println();
                    System.out.println("Enter your selection: ");
                    selection2 = scanner.nextInt();

                    switch (selection2) {
                        case 1:
                            System.out.println("\nYou selected: Create new reservation");
                            ManageReservations.createNewReservation(guests, rooms, reservations, scanner);
                            break;
                        case 2:
                            System.out.println("\nYou selected: Show all reservations");
                            ManageReservations.showAllReservations(reservations, scanner);
                            break;
                        case 3:
                            System.out.println("\nYou selected: Get reservation by guest name");
                            ManageReservations.getReservationByGuestName(reservations, scanner);
                            break;
                        case 4:
                            System.out.println("\nYou selected: Get reservation by guest ID");
                            ManageReservations.getReservationByGuestId(reservations, scanner);
                            break;
                        case 5:
                            System.out.println("\nYou selected: Edit reservation");
                            ManageReservations.editReservation(guests, rooms, reservations, scanner);
                            break;
                        case 6:
                            System.out.println("\nYou selected: Pay reservation");
                            ManageReservations.payReservation(reservations, scanner);
                            break;
                        case 0:
                            System.out.println("\nYou selected: Quit");
                            break;
                        default:
                            System.out.println("\nInvalid selection. Please try again.");
                            break;
                    }

                    break;
                case 4:
                    // show employee options
                    System.out.println("\nEmployee Options");
                    System.out.println("1. Add new employee\n" +
                            "2. Show all employees\n" +
                            "3. Search employee by name\n" +
                            "4. Edit employee data");
                    System.out.println();
                    System.out.println("Enter your selection: ");
                    selection2 = scanner.nextInt();

                    switch (selection2) {
                        case 1:
                            System.out.println("\nYou selected: Add new employee");
                            ManageEmployees.addNewEmployee(employees, scanner);
                            break;
                        case 2:
                            System.out.println("\nYou selected: Show all employees");
                            ManageEmployees.showAllEmployees(employees);
                            break;
                        case 3:
                            System.out.println("\nYou selected: Search employee by name");
                            ManageEmployees.searchEmployeeByName(employees, scanner);
                            break;
                        case 4:
                            System.out.println("\nYou selected: Edit employee data");
                            break;
                        case 0:
                            System.out.println("\nYou selected: Quit");
                            break;
                        default:
                            System.out.println("\nInvalid selection. Please try again.");
                            break;
                    }

                    break;
                case 0:
                    exit = true;
                    System.out.println();
                    System.out.println("Closing Hotel Pochacco Management System");
                    displayAsciiArt("pochacco_ascii.txt");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void displayAsciiArt(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading ASCII art file: " + e.getMessage());
        }
    }
}
