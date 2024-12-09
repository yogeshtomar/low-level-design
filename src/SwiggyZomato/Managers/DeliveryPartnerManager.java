package SwiggyZomato.Managers;

import SwiggyZomato.models.DeliveryPartner;
import SwiggyZomato.models.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryPartnerManager {
	private static volatile DeliveryPartnerManager INSTANCE = null;
	private Map<String, DeliveryPartner> deliveryPartnerMap;

	private DeliveryPartnerManager() {
		// Initialize the delivery partner map
		deliveryPartnerMap = new HashMap<>();
	}

	public static DeliveryPartnerManager getInstance() {
		if (INSTANCE == null) {
			synchronized (DeliveryPartnerManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new DeliveryPartnerManager();
				}
			}
		}
		return INSTANCE;
	}

	public void addDeliveryPartner(DeliveryPartner deliveryPartner) {
		deliveryPartnerMap.put(deliveryPartner.getName(), deliveryPartner);
	}

	public DeliveryPartner getDeliveryPartner(String name) {
		return deliveryPartnerMap.get(name);
	}

	public List<DeliveryPartner> getDeliveryPartnerByLocation(Location location) {
		// Get the delivery partner by location
		double allowedDistance = 10.0;
		List<DeliveryPartner> returnDeliveryPartnerList = new ArrayList<>();
		for (Map.Entry<String, DeliveryPartner> entry : deliveryPartnerMap.entrySet()) {

			DeliveryPartner deliveryPartner = entry.getValue();
			double currentDistance = Math.sqrt(Math.pow(deliveryPartner.getCurrentLocation().getLongitude() - location.getLongitude(), 2)
					+ Math.pow(deliveryPartner.getCurrentLocation().getLatitude() - location.getLatitude(), 2));
			if(currentDistance < allowedDistance) {
				returnDeliveryPartnerList.add(deliveryPartner);
			}
		}
		return returnDeliveryPartnerList;
	}
}
