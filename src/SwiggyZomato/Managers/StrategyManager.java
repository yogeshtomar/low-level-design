package SwiggyZomato.Managers;

import SwiggyZomato.models.DeliveryMetaData;
import SwiggyZomato.strategies.InterfaceDeliveryPartnerMatchingStrategy;
import SwiggyZomato.strategies.LocationBasedDeliveryPartnerMatchingStrategy;

public class StrategyManager {
	private static volatile StrategyManager instance;

	private StrategyManager() {
	}

	public static StrategyManager getInstance() {
		if (instance == null) {
			synchronized (StrategyManager.class) {
				if (instance == null) {
					instance = new StrategyManager();
				}
			}
		}
		return instance;
	}

	public InterfaceDeliveryPartnerMatchingStrategy determineDeliveryPartnerMatchingStrategy(DeliveryMetaData deliveryMetaData) {
		// Determine the delivery partner matching strategy
		System.out.println("based on location, weather and other factors, setting partner strategy");
		return new LocationBasedDeliveryPartnerMatchingStrategy();

	}
}
