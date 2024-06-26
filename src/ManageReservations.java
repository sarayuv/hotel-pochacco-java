package main.java;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageReservations {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");

    public static void createNewReservation(ArrayList<Guest> guests, ArrayList<Room> rooms,
            ArrayList<Reservation> reservations, Scanner scanner) {
        System.out.println("Enter arrival date (yyyy-MM-dd): ");
        String arrDate = scanner.next();

        System.out.println("Enter departure date (yyyy-MM-dd): ");
        String depDate = scanner.next();

        System.out.println("Enter guest ID (int): \nEnter \1 to search guest by name");
        int guestId = scanner.nextInt();
        if (guestId == -1) {
            ManageGuests.searchGuestByName(guests, scanner);
            System.out.println("Enter guest ID (int): ");
            guestId = scanner.nextInt();
        }

        System.out.println("Enter room ID (int): \nEnter -1 to show all rooms");
        int roomId = scanner.nextInt();
        if (roomId == -1) {
            ManageRooms.showAllRooms(rooms);
            System.out.println("Enter room ID (int): ");
            roomId = scanner.nextInt();
        }

        LocalDate arrival = LocalDate.parse(arrDate, formatter);
        LocalDate departure = LocalDate.parse(depDate, formatter);

        Guest guest = guests.get(guestId);
        Room room = ManageRooms.getRoomById(roomId, rooms);

        if (room.isReserved(arrival, departure)) {
            System.out.println("This room is reserved");
            return;
        } else {
            int days = Period.between(arrival, departure).getDays();
            double total = days * room.getPrice();
            System.out.println("Total: " + total);
            System.out.println("Will you pay now?\n1. Yes\n2. No");
            int z = scanner.nextInt();
            String status;
            if (z == 1) {
                status = "Paid";
            } else {
                status = "Reserved";
            }

            Reservation r = new Reservation(arrival, departure, total, status, guest, room);
            reservations.add(r);
            r.print();
            System.out.println();
        }
    }

    public static void showAllReservations(ArrayList<Reservation> reservations, Scanner scanner) {
        for (Reservation r : reservations) {
            System.out.println("\n---------------------------------------");
            System.out.println("id: " + reservations.indexOf(r));
            System.out.println("Arrival Date: " + r.getArrivaltoString());
            System.out.println("Departure Date: " + r.getDeparturetoString());
            System.out.println("Guest Name: " + r.getGuest().getName());
            System.out.println("Room id: " + r.getRoom().getId());
            System.out.println("Price: " + r.getPrice());
            System.out.println("Status: " + r.getStatus());
            System.out.println("---------------------------------------");
        }
    }

    public static void getReservationByGuestName(ArrayList<Reservation> reservations, Scanner scanner) {
        System.out.println("Enter guest name (String): ");
        String guestName = scanner.next();
        for (Reservation r : reservations) {
            String name = r.getGuest().getName();
            if (guestName.equals(name)) {
                r.print();
            }
        }
    }

    public static void getReservationByGuestId(ArrayList<Reservation> reservations, Scanner scanner) {
        System.out.println("Enter guest ID (int): ");
        int guestId = scanner.nextInt();
        for (Reservation r : reservations) {
            int id = r.getGuest().getId();
            if (guestId == id)
                r.print();
        }
    }

    public static void editReservation(ArrayList<Guest> guests, ArrayList<Room> rooms,
            ArrayList<Reservation> reservations, Scanner scanner) {
        System.out.println("Enter reservation ID (int): \nEnter -1 to show all reservation IDs");
        int id = scanner.nextInt();
        if (id == -1) {
            showAllReservations(reservations, scanner);
            System.out.println("Enter reservation ID (int): ");
            id = scanner.nextInt();
        }

        Reservation reservation = reservations.get(id);

        System.out.println("Enter arrival date (yyyy-MM-dd): \nEnter -1 to keep arrival date");
        String arrDate = scanner.next();
        if (arrDate.equals("-1")) {
            arrDate = reservation.getArrivaltoString();
        }

        System.out.println("Enter departure date (yyyy-MM-dd): \nEnter -1 to keep departure date");
        String depDate = scanner.next();
        if (depDate.equals("-1")) {
            depDate = reservation.getDeparturetoString();
        }

        System.out.println("Enter room ID (int): \nEnter -1 to keep room ID\nEnter -2 to show all rooms");
        int roomId = scanner.nextInt();
        if (roomId == -1) {
            roomId = reservation.getRoom().getId();
        } else if (roomId == -2) {
            ManageRooms.showAllRooms(rooms);
            System.out.println("Enter room ID (int): ");
            roomId = scanner.nextInt();
        }

        LocalDate arrival = LocalDate.parse(arrDate, formatter);
        LocalDate departure = LocalDate.parse(depDate, formatter);

        Guest guest = reservation.getGuest();
        Room room = ManageRooms.getRoomById(roomId, rooms);
        if (room.isReserved(arrival, departure)) {
            System.out.println("This room is reserved");
            return;
        } else {
            int days = Period.between(arrival, departure).getDays();
            double total = days * room.getPrice();
            System.out.println("Total: " + total);

            System.out.println("Will you pay now?\n1. Yes\n2. No");
            int z = scanner.nextInt();
            String status;
            if (z == 1) {
                status = "Paid";
            } else {
                status = "Reserved";
            }

            reservation.setArrival(arrival);
            reservation.setDeparture(departure);
            reservation.setGuest(guest);
            reservation.setRoom(room);
            reservation.setStatus(status);
            reservation.setPrice(total);
            reservations.set(id, reservation);
            reservation.print();
            System.out.println();
        }
    }

    public static void payReservation(ArrayList<Reservation> reservations, Scanner scanner) {
        System.out.println("Enter reservation ID (int): \nEnter -1 to show all reservation IDs");
        int id = scanner.nextInt();
        if (id == -1) {
            showAllReservations(reservations, scanner);
            System.out.println("Enter reservation ID (int): ");
            id = scanner.nextInt();
        }

        Reservation reservation = reservations.get(id);
        if (reservation.getStatus().equals("Reserved")) {
            reservation.setStatus("Paid");
            System.out.println("Reservation paid successfully");
        } else {
            System.out.println("This reservation has already been paid");
        }
    }
}
