package OlaUber.strategies;

import OlaUber.models.Driver;
import OlaUber.models.TripMetadata;

public interface DriverMatchingStrategy {
	public Driver matchDriver(TripMetadata tripMetadata);
}
