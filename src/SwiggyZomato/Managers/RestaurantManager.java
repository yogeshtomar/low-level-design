package SwiggyZomato.Managers;

import SwiggyZomato.models.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class RestaurantManager {
	private static volatile RestaurantManager INSTANCE = null;
	private Map<String, Restaurant> restaurantMap;
	private RestaurantManager() {
		restaurantMap = new HashMap<>();
	}

	public static RestaurantManager getInstance() {
		if (INSTANCE == null) {
			synchronized (RestaurantManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new RestaurantManager();
				}
			}
		}
		return INSTANCE;
	}

	public void addRestaurant(Restaurant restaurant) {
		restaurantMap.put(restaurant.getName(), restaurant);
	}

	public Restaurant getRestaurant(String name) {
		return restaurantMap.get(name);
	}
}
