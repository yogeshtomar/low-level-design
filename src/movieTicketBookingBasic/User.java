package movieTicketBookingBasic;

class User implements Runnable {
    private final OnlineMovieTheatre theater;
    private final String name;
    private final int seatNumber;

    public User(OnlineMovieTheatre theater, String name, int seatNumber) {
        this.theater = theater;
        this.name = name;
        this.seatNumber = seatNumber;
    }

    @Override
    public void run() {
        boolean success = theater.bookSeat(name, seatNumber);
        if (!success) {
            System.out.println(name + " failed to book Seat " + seatNumber + ".");
        }
    }
}