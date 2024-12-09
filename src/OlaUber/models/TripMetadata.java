package OlaUber.models;

import OlaUber.enums.Rating;

public class TripMetadata {
	private Location source;
	private Location destination;
	private long startTime;
	private long endTime;
	private int tripId;

	private Rating driverRating;
	private Rating riderRating;

	public TripMetadata(Location source, Location destination, long startTime,  int tripId, Rating riderRating) {
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = -1;
		this.tripId = tripId;
		this.riderRating = riderRating;
		driverRating = Rating.UNASSIGNED;
	}

	public Location getSource() {
		return source;
	}

	public Location getDestination() {
		return destination;
	}

	public long getStartTime() {
		return startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public int getTripId() {
		return tripId;
	}

	public Rating getRiderRating() {
		return riderRating;
	}

	public void setDriverRating(Rating driverRating) {
		this.driverRating = driverRating;
	}
}
