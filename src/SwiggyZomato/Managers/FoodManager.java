package SwiggyZomato.Managers;

import SwiggyZomato.models.Dish;
import SwiggyZomato.models.Restaurant;
import SwiggyZomato.services.PushNotificationSenderImpl;

import java.util.Map;

public class FoodManager {
	private static volatile FoodManager INSTANCE = null;
	private FoodManager() {
		// Initialize the food manager
	}

	public static FoodManager getInstance() {
		if (INSTANCE == null) {
			synchronized (FoodManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new FoodManager();
				}
			}
		}
		return INSTANCE;
	}

	public void addRestaurantForNotificationUpdates(String orderId, String restaurantName) {
		// Add the restaurant for notification updates
		NotificationManager notificationManager = NotificationManager.getInstance();
		notificationManager.addNotificationSender(new PushNotificationSenderImpl(), restaurantName, orderId);
	}

	public void prepareFood(String orderId, String restaurantName, Map<Dish, Integer> dishes) throws InterruptedException {
		// Prepare the food
		RestaurantManager restaurantManager = RestaurantManager.getInstance();
		Restaurant restaurant = restaurantManager.getRestaurant(restaurantName);
		if(restaurant != null) {
			restaurant.prepareFood(orderId, dishes);
		}

		addRestaurantForNotificationUpdates(orderId, restaurantName);
	}
}
