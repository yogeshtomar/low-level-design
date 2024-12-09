package OlaUber;

import OlaUber.Managers.DriverManager;
import OlaUber.Managers.RiderManager;
import OlaUber.Managers.TripManager;
import OlaUber.enums.Rating;
import OlaUber.models.Driver;
import OlaUber.models.Location;
import OlaUber.models.Rider;
import OlaUber.models.Trip;

import java.util.Map;

public class UberSystemApplication {
	public static void main(String[] args) {
		System.out.println("Welcome to Uber System");
		RiderManager riderManager = RiderManager.getInstance();
		DriverManager driverManager = DriverManager.getInstance();

		Rider yogesh = new Rider("yogesh", "9910348407", Rating.FIVE_STAR);
		Rider subhash = new Rider("subhash", "9966778899", Rating.FIVE_STAR);
		riderManager.addRider(yogesh);
		riderManager.addRider(subhash);

		Driver ravi = new Driver("ravi", Rating.FOUR_STAR, "9910348558");
		Driver vikas = new Driver("vikas", Rating.TWO_STAR, "9898110012");
		driverManager.addDriver(ravi);
		driverManager.addDriver(vikas);

		TripManager tripManager = TripManager.getInstance();

		System.out.println("Creating Trip from yogesh from location (10.0, 20.0) to location (30.0, 40.0)");
		tripManager.createTrip(yogesh, new Location(10.0, 20.0), new Location(30.0, 40.0), tripManager.generateTripId());

		System.out.println("Creating Trip from subhash from location (20.0, 30.0) to location (300.0, 500.0)");
		tripManager.createTrip(subhash, new Location(20.0, 30.0), new Location(300.0, 500.0), tripManager.generateTripId());

		Map<Integer, Trip> tripMap = tripManager.getTripMap();

		System.out.println("Displaying all the trips");
		for (Map.Entry<Integer, Trip> entry : tripMap.entrySet()) {
			System.out.println("TripId: " + entry.getKey() + " Trip: " + entry.getValue().getTripDetails());
		}
	}
}
