package SwiggyZomato.models;

import SwiggyZomato.enums.ORDER_STATUS;

import java.util.Map;

public class Order {
	private User user;
	private Restaurant restaurant;
	private Map<Dish, Integer> dishes;
	private String discountCode;
	private String paymentId;
	private ORDER_STATUS orderStatus;
	public Order(User user, Restaurant restaurant, Map<Dish, Integer> dishes, String discountCode, String paymentId) {
		this.user = user;
		this.restaurant = restaurant;
		this.dishes = dishes;
		this.discountCode = discountCode;
		this.paymentId = paymentId;
		this.orderStatus = ORDER_STATUS.PLACED;
	}
	public String getUserId() {
		return user.getPhone();
	}

	public String getRestaurantId() {
		return restaurant.getName();
	}

	public Map<Dish, Integer> getDishes() {
		return dishes;
	}

	public Location getDeliveryLocation() {
		return user.getLocation();
	}

	public Location getRestaurantLocation() {
		return restaurant.getLocation();
	}

	public ORDER_STATUS getOrderStatus() {
		return orderStatus;
	}
}
