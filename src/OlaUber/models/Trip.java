package OlaUber.models;

import OlaUber.enums.TRIP_STATUS;
import OlaUber.strategies.DriverMatchingStrategy;
import OlaUber.strategies.PricingStrategy;

public class Trip {
	Rider rider;
	Driver driver;

	Location srcLocation;
	Location destLocation;
	TRIP_STATUS status;
	int tripId;

	double fare;
	PricingStrategy pricingStrategy;
	DriverMatchingStrategy driverMatchingStrategy;

	public Trip(Rider rider, Driver driver, Location srcLocation, Location destLocation, int tripId, double fare,PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
		this.rider = rider;
		this.driver = driver;
		this.srcLocation = srcLocation;
		this.destLocation = destLocation;
		this.pricingStrategy = pricingStrategy;
		this.driverMatchingStrategy = driverMatchingStrategy;
		this.status = TRIP_STATUS.DRIVER_ON_THE_WAY;
		this.tripId = tripId;
		this.fare = fare;
	}

	public String getTripDetails() {
		return "Trip ID: " + tripId + " Rider: " + rider.getName() + " Driver: " + driver.getName() + " Fare: " + fare + " Source: " + srcLocation + " Destination: " + destLocation;
	}
}
