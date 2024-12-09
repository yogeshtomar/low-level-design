package SwiggyZomato.Managers;

import SwiggyZomato.models.DeliveryMetaData;
import SwiggyZomato.models.DeliveryPartner;
import SwiggyZomato.services.PushNotificationSenderImpl;
import SwiggyZomato.strategies.InterfaceDeliveryPartnerMatchingStrategy;

import java.util.List;

public class DeliveryManager {
	private static DeliveryManager instance = null;

	private DeliveryManager() {
	}

	public static DeliveryManager getInstance() {
		if (instance == null) {
			synchronized (DeliveryManager.class) {
				if (instance == null) {
					instance = new DeliveryManager();
				}
			}
		}
		return instance;
	}

	public void manageDelivery(String orderId, DeliveryMetaData deliveryMetaData) throws InterruptedException {
		StrategyManager strategyManager = StrategyManager.getInstance();

		InterfaceDeliveryPartnerMatchingStrategy deliveryPartnerMatchingStrategy = strategyManager.determineDeliveryPartnerMatchingStrategy(deliveryMetaData);
		List<DeliveryPartner> nearestDeliveryPartners = deliveryPartnerMatchingStrategy.matchDeliveryPartner(deliveryMetaData);
		if (nearestDeliveryPartners.isEmpty()) {
			System.out.println("No delivery partners available");
			return;
		}

		NotificationManager notificationManager = NotificationManager.getInstance();
		for (DeliveryPartner deliveryPartner : nearestDeliveryPartners) {
			notificationManager.notifyParticularUser(deliveryPartner.getName(), "Delivery Request", new PushNotificationSenderImpl());
		}

		// Assuming first delivery partner accepted the request
		DeliveryPartner deliveryPartner = nearestDeliveryPartners.get(0);
		System.out.println("Delivery Partner: " + deliveryPartner.getName() + " assigned for the order: " + orderId);
		notificationManager.notify(orderId, "\nDelivery Partner: " + deliveryPartner.getName() + "assigned for the order: " + orderId);
		deliveryPartner.performDeliver(orderId, deliveryMetaData);

	}
}
