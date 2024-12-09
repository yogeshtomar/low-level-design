package OlaUber.strategies;

import OlaUber.models.TripMetadata;

public class DefaultPricingStrategy implements PricingStrategy{
	@Override
	public double calculateFare(TripMetadata tripMetadata) {
		System.out.println("DefaultPricingStrategy.calculateFare");
		return 100.0;
	}
}
