package OlaUber.models;

import OlaUber.enums.Rating;

public class Rider {
	private String name;
	private String phoneNo;
	private Rating rating;

	public Rider(String name, String phoneNo, Rating rating) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public Rating getRating() {
		return rating;
	}
}
