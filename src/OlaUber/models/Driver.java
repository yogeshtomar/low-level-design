package OlaUber.models;

import OlaUber.enums.Rating;

public class Driver {
	private String name;
	private boolean available;
	private Rating rating;

	private String phoneNo;

	public Driver(String name, Rating rating, String phoneNo) {
		this.name = name;
		this.rating = rating;
		this.phoneNo = phoneNo;
	}

	void updateAvailability(boolean available) {
		this.available = available;
	}

	public String getName() {
		return name;
	}

	public boolean isAvailable() {
		return available;
	}

	public Rating getRating() {
		return rating;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
}
