package OlaUber.strategies;

import OlaUber.models.TripMetadata;

public interface PricingStrategy {
	double calculateFare(TripMetadata tripMetadata);
}
