package OlaUber.Managers;

import OlaUber.models.Driver;
import OlaUber.models.Location;
import OlaUber.models.Rider;
import OlaUber.models.Trip;
import OlaUber.models.TripMetadata;
import OlaUber.strategies.DriverMatchingStrategy;
import OlaUber.strategies.PricingStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TripManager {
	private static volatile TripManager INSTANCE = null;
	Map<Integer, Trip> tripMap = null;

	private TripManager() {
		tripMap = new HashMap<>();
	}

	public static TripManager getInstance() {
		if (INSTANCE == null) {
			synchronized (TripManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new TripManager();
				}
			}
		}
		return  INSTANCE;
	}

	public int generateTripId() {
		return ThreadLocalRandom.current().nextInt(10000000, 99999999);
	}

	public void createTrip(Rider rider, Location src, Location dest, int tripId) {
		TripMetadata tripMetadata = new TripMetadata(src, dest, System.currentTimeMillis(), tripId, rider.getRating());
		StrategyManager strategyManager = StrategyManager.getInstance();
		DriverMatchingStrategy driverMatchingStrategy = strategyManager.determineDriverMatchingStrategy(tripMetadata);
		PricingStrategy pricingStrategy = strategyManager.determinePricingStrategy(tripMetadata);

		Driver driver = driverMatchingStrategy.matchDriver(tripMetadata);
		double fare = pricingStrategy.calculateFare(tripMetadata);

		Trip trip = new Trip(rider, driver, src, dest, tripId, fare, pricingStrategy, driverMatchingStrategy);
		System.out.println("Trip Created: " + trip.getTripDetails());
		tripMap.put(tripId, trip);
	}

	public Map<Integer, Trip> getTripMap() {
		return tripMap;
	}

	public Trip getTrip(String tripId) {
		return tripMap.get(tripId);
	}
}
