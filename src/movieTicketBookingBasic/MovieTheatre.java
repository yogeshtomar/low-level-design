package movieTicketBookingBasic;

import java.util.concurrent.TimeUnit;

public class MovieTheatre {
    private final boolean[] seats;
    private final int totalSeats;

    public MovieTheatre(int totalSeats) {
        this.totalSeats = totalSeats;
        seats = new boolean[totalSeats+1];
    }

    public boolean bookSeat(String user, int seatNo) {
        System.out.println("user: " + user + " is trying to book seat no: " + seatNo + ".");
        if (seatNo < 1 || seatNo >= totalSeats) {
            System.out.println("user: " + user + " the seat you are trying to book doesn't exist.");
            return false;
        }
        if (!seats[seatNo]) {
            seats[seatNo] = true;
//            System.out.println("user: " + user + " successfully booked the seat: " + seatNo);
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        else {
            System.out.println("user: " + user + " the seat: " + seatNo + " is already booked");
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


//H943XI