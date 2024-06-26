package main.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Room {

    private int id;
    private int floor;
    private int capacity;
    private String description;
    private double price;
    private ArrayList<String> reservedDates;

    public Room(int id, int floor, int capacity, String description, double price) {
        this.id = id;
        this.floor = floor;
        this.capacity = capacity;
        this.description = description;
        this.price = price;
        reservedDates = new ArrayList<>();
    }

    public Room() {
        reservedDates = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void Reserve(LocalDate startDate, LocalDate finishDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        for (LocalDate date = startDate; date.isBefore(finishDate); date = date.plusDays(1)) {
            String d = date.format(formatter);
            reservedDates.add(d);
        }
    }

    public boolean isReserved(LocalDate startDate, LocalDate finishDate) {
        boolean b = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (LocalDate date = startDate; date.isBefore(finishDate); date = date.plusDays(1)) {
            String d = date.format(formatter);
            if (reservedDates.contains(d)) {
                b = true;
                break;
            }
        }
        return b;
    }

    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Floor: " + floor);
        System.out.println("Capacity: " + capacity);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
    }
}
