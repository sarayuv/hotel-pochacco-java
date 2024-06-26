package main.java;

import java.util.ArrayList;
import java.util.Scanner;;

public class ManageRooms {

    public static void addNewRoom(ArrayList<Room> rooms, Scanner scanner) {
        System.out.println("Enter floor (int): ");
        int floor = scanner.nextInt();
        System.out.println("Enter capacity (int): ");
        int capacity = scanner.nextInt();
        System.out.println("Enter description (String): ");
        String description = scanner.next();
        System.out.println("Enter price (double): ");
        double price = scanner.nextDouble();

        // make an ID for the room
        int id = 1000 + rooms.size();

        Room room = new Room(id, floor, capacity, description, price);
        rooms.add(room);
        System.out.println("Room added successfully!");
    }

    public static void showAllRooms(ArrayList<Room> rooms) {
        for (Room room : rooms) {
            System.out.println("--------------------------------");
            room.print();
            System.out.println("--------------------------------");
            System.out.println();
        }
    }

    public static void editRoom(ArrayList<Room> rooms, Scanner scanner) {
        System.out.println("Enter room ID: ");
        int id = scanner.nextInt();
        Room room = getRoomById(id, rooms);

        System.out.println("Enter floor (int): \nEnter -1 to keep the floor");
        int floor = scanner.nextInt();
        if (floor == -1) {
            floor = room.getFloor();
        }

        System.out.println("Enter capacity (int): \nEnter -1 to keep the capacity");
        int capacity = scanner.nextInt();
        if (capacity == -1) {
            capacity = room.getCapacity();
        }

        System.out.println("Enter room description (String): \nEnter -1 to keep the room description");
        String description = scanner.next();
        if (description.equals("-1")) {
            description = room.getDescription();
        }

        System.out.println("Enter price (double): \nEnter -1 to keep the price");
        double price = scanner.nextDouble();
        if (price == -1) {
            price = room.getPrice();
        }

        room.setFloor(floor);
        room.setCapacity(capacity);
        room.setDescription(description);
        room.setPrice(price);

        for (Room r : rooms) {
            if (r.getId() == id) {
                r = room;
                break;
            }
        }
    }

    public static Room getRoomById(int id, ArrayList<Room> rooms) {
        Room room = new Room();
        for (Room r : rooms) {
            if (r.getId() == id) {
                room = r;
                break;
            }
        }

        return room;
    }

}
