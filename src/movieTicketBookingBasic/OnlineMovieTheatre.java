package movieTicketBookingBasic;

import java.util.concurrent.TimeUnit;

public class OnlineMovieTheatre {
    private final boolean[] seats;
    private final int totalSeats;

    public OnlineMovieTheatre(int totalSeats) {
        this.totalSeats = totalSeats;
        seats = new boolean[totalSeats+1];
    }

    // Synchronize this method to book a specific seat
    public  boolean bookSeat(String user, int seatNumber) {
        System.out.println(user + " is trying to book Seat " + seatNumber + ".");

        if (seatNumber < 0 || seatNumber >= seats.length) {
            System.out.println(user + ": Seat " + seatNumber + " does not exist.");
            return false;
        }

        if (!seats[seatNumber]) { // Seat is available
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            seats[seatNumber] = true; // Mark seat as booked
            System.out.println(user + " successfully booked Seat " + seatNumber + ".");
            return true;
        } else { // Seat is already booked
            System.out.println(user + ": Seat " + seatNumber + " is already booked.");
            return false;
        }
    }

    public void displayAvailableSeats() {
        System.out.print("Available seats: ");
        for (int i = 0; i < seats.length; i++) {
            if (!seats[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}