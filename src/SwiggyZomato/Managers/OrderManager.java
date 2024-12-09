package SwiggyZomato.Managers;

import SwiggyZomato.models.DeliveryMetaData;
import SwiggyZomato.models.Order;
import SwiggyZomato.services.SmsNotificationSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
	private static volatile  OrderManager instance;
	private Map<String, Order> orderMap;
	private DeliveryManager deliveryManager;
	private FoodManager foodManager;

	private OrderManager() {
		orderMap = new HashMap<>();
	}

	public static OrderManager getInstance() {
		if (instance == null) {
			synchronized (OrderManager.class) {
				if (instance == null) {
					instance = new OrderManager();
				}
			}
		}
		return instance;
	}

	private void addUserForNotificationUpdates(String orderId, Order order) {
		// Add the user for notification updates
		NotificationManager notificationManager = NotificationManager.getInstance();
		notificationManager.addNotificationSender(new SmsNotificationSenderImpl(), order.getUserId(), orderId);
	}

	private void manageDelivery(String orderId, Order order) throws InterruptedException {
		// Manage the delivery
		DeliveryMetaData deliveryMetaData = new DeliveryMetaData(orderId, order.getDeliveryLocation(), order.getRestaurantLocation());
		deliveryManager = DeliveryManager.getInstance();
		deliveryManager.manageDelivery(orderId, deliveryMetaData);
	}

	private void manageFood(String orderId, Order order) throws InterruptedException {
		// Manage the food
		foodManager = FoodManager.getInstance();
		foodManager.prepareFood(orderId, order.getRestaurantId(), order.getDishes());
	}

	public  void createOrder(String orderId, Order order) throws InterruptedException {
		// Create the order
		orderMap.put(orderId, order);
		addUserForNotificationUpdates(orderId, order);
		manageFood(orderId, order);
		manageDelivery(orderId, order);
	}

	public Order getOrder(String orderId) {
		return orderMap.get(orderId);
	}
}
