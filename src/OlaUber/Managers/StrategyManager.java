package OlaUber.Managers;

import OlaUber.models.TripMetadata;
import OlaUber.strategies.DefaultPricingStrategy;
import OlaUber.strategies.DriverMatchingStrategy;
import OlaUber.strategies.LeastTimeBasedMatchingStrategy;
import OlaUber.strategies.PricingStrategy;

public class StrategyManager {
	private static volatile StrategyManager INSTANCE = null;
	PricingStrategy pricingStrategy = null;
	DriverMatchingStrategy driverMatchingStrategy = null;

	private StrategyManager() {
		pricingStrategy = new DefaultPricingStrategy();
	}

	public static StrategyManager getInstance() {
		if (INSTANCE == null) {
			synchronized (StrategyManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new StrategyManager();
				}
			}
		}
		return  INSTANCE;
	}

	public PricingStrategy determinePricingStrategy(TripMetadata tripMetadata) {
		System.out.println("Based on Location and other factors, setting pricing strategy");
		return new DefaultPricingStrategy();
	}

	public DriverMatchingStrategy determineDriverMatchingStrategy(TripMetadata tripMetadata) {
		System.out.println("Based on Location and other factors, setting driver matching strategy");
		return new LeastTimeBasedMatchingStrategy();
	}
}
