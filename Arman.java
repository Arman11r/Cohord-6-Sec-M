
import java.util.*;

class Flight {
    String flightNumber;
    String destination;
    String departureTime;
    int totalSeats;
    boolean[] seats;

    public Flight(String flightNumber, String destination, String departureTime, int totalSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.seats = new boolean[totalSeats];
    }

    public boolean reserveSeat() throws Exception {
        for (int i = 0; i < totalSeats; i++) {
            if (!seats[i]) {
                seats[i] = true;
                return true;
            }
        }
        throw new Exception("Flight " + flightNumber + " is fully booked.");
    }

    public boolean cancelSeat() {
        for (int i = 0; i < totalSeats; i++) {
            if (seats[i]) {
                seats[i] = false;
                return true;
            }
        }
        return false;
    }

    public int getAvailableSeats() {
        int count = 0;
        for (boolean seat : seats) {
            if (!seat) count++;
        }
        return count;
    }

    public void displayDetails() {
        System.out.println("Flight: " + flightNumber + ", To: " + destination + ", At: " + departureTime +
                           ", Available Seats: " + getAvailableSeats());
    }
}

public class Arman {
    static List<Flight> flights = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        flights.add(new Flight("F101", "Delhi", "10:00", 5));
        flights.add(new Flight("F202", "Mumbai", "14:00", 3));

        while (true) {
            System.out.println("\n1. Search Flight\n2. Reserve Seat\n3. Cancel Reservation\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Destination or Departure Time: ");
                        String input = sc.nextLine();
                        searchFlight(input);
                        break;
                    case 2:
                        System.out.print("Enter Flight Number to Reserve: ");
                        reserveSeat(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Enter Flight Number to Cancel: ");
                        cancelSeat(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void searchFlight(String keyword) {
        boolean found = false;
        for (Flight flight : flights) {
            if (flight.destination.equalsIgnoreCase(keyword) || flight.departureTime.equalsIgnoreCase(keyword)) {
                flight.displayDetails();
                found = true;
            }
        }
        if (!found) System.out.println("No flights found for given input.");
    }

    public static void reserveSeat(String flightNumber) throws Exception {
        for (Flight flight : flights) {
            if (flight.flightNumber.equalsIgnoreCase(flightNumber)) {
                if (flight.reserveSeat()) {
                    System.out.println("Seat reserved successfully!");
                }
                return;
            }
        }
        throw new Exception("Invalid Flight Number!");
    }

    public static void cancelSeat(String flightNumber) throws Exception {
        for (Flight flight : flights) {
            if (flight.flightNumber.equalsIgnoreCase(flightNumber)) {
                if (flight.cancelSeat()) {
                    System.out.println("Reservation cancelled.");
                } else {
                    System.out.println("No reservations to cancel.");
                }
                return;
            }
        }
        throw new Exception("Invalid Flight Number!");
    }
}