package OlaUber.strategies;

import OlaUber.Managers.DriverManager;
import OlaUber.models.Driver;
import OlaUber.models.TripMetadata;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {
	@Override
	public Driver matchDriver(TripMetadata tripMetadata) {
		System.out.println("LeastTimeBasedMatchingStrategy.matchDriver");
		DriverManager driverManager = DriverManager.getInstance();
		if (driverManager.getDriverMap().size() == 0) {
			System.out.println("No drivers available");
			return null;
		}
		System.out.println("Using Quad Tree to find the nearest cab, using driver manager to get details of driver and send notifications");
		// Quad Tree Algorithm can be implemented here to find the nearest cab, using driver manager to get details of driver and send notifications
		Driver driver = driverManager.getDriverMap().values().iterator().next();
		System.out.println("Driver found: " + driver.getName());
		tripMetadata.setDriverRating(driver.getRating());
		return driver;
	}
}
