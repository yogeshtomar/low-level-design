package movieTicketBookingBasic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OnlineTicketBookingApplication {
    public static void main(String[] args) {
        int capacity = 5;
        MovieTheatre theatre = new MovieTheatre(5);
        System.out.println("Initial state of seats:");
        theatre.displayAvailableSeats();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new User(theatre, "User1", 2));
        executorService.execute(new User(theatre, "User2", 2));
        executorService.execute(new User(theatre, "User3", 3));
        executorService.execute(new User(theatre, "User4", 2));
        executorService.execute(new User(theatre, "User5", 4));

        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        System.out.println("\nFinal State of Seats:");
        theatre.displayAvailableSeats();
    }
}
