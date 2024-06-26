package main.java;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private LocalDate arrival;
    private LocalDate departure;
    private double price;
    private String status;
    private Guest guest;
    private Room room;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Reservation(LocalDate arrival, LocalDate departure, double price, String status, Guest guest,
            Room room) {
        this.arrival = arrival;
        this.departure = departure;
        this.price = price;
        this.status = status;
        this.guest = guest;
        this.room = room;
    }

    public Reservation() {
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public String getArrivaltoString() {
        return arrival.format(formatter);
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public String getDeparturetoString() {
        return departure.format(formatter);
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void print() {
        System.out.println("\n***********************************");
        System.out.println("Arrival Date: " + arrival.format(formatter));
        System.out.println("Departure Date: " + departure.format(formatter));
        int days = Period.between(arrival, departure).getDays();
        System.out.println(days + " Days");
        System.out.println("******* Guest Information *******");
        guest.print();
        System.out.println("******* Room Information *******");
        room.print();
        System.out.println("*********** Total ***********");
        double price = days * room.getPrice();
        System.out.println("Price: " + price);
        System.out.println("***********************************\n");
    }
}
