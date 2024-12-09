package SwiggyZomato.strategies;

import SwiggyZomato.Managers.DeliveryPartnerManager;
import SwiggyZomato.models.DeliveryMetaData;
import SwiggyZomato.models.DeliveryPartner;
import SwiggyZomato.models.Location;

import java.util.List;

public class LocationBasedDeliveryPartnerMatchingStrategy implements InterfaceDeliveryPartnerMatchingStrategy {
	@Override
	public List<DeliveryPartner> matchDeliveryPartner(DeliveryMetaData deliveryMetaData) {
		Location restaurantLocation = deliveryMetaData.getRestaurantLocation();
		DeliveryPartnerManager deliveryPartnerManager = DeliveryPartnerManager.getInstance();
		return deliveryPartnerManager.getDeliveryPartnerByLocation(restaurantLocation);
	}
}
