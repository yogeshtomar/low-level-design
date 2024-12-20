package movieTicketBookingBasic;

public class User implements Runnable {
    private final MovieTheatre theatre;
    private final String name;
    private final int seatNo;

    public User(MovieTheatre theatre, String name, int seatNo) {
        this.theatre = theatre;
        this.name = name;
        this.seatNo = seatNo;
    }


    @Override
    public void run() {
        boolean success = theatre.bookSeat(name, seatNo);
        if (!success) {
            System.out.println(name + " failed to book Seat " + seatNo + ".");
        }
    }
}
