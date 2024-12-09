package SwiggyZomato.models;

import SwiggyZomato.Managers.NotificationManager;
import SwiggyZomato.enums.RATINGS;

import java.util.Map;

public class Restaurant {
	private String name;
	private Menu menu;
	private Location location;
	private RestaurantOwner owner;
	private boolean isAvailable;
	private RATINGS rating;

	public Restaurant(String name, Menu menu, Location location, RestaurantOwner owner, boolean isAvailable, RATINGS rating) {
		this.name = name;
		this.menu = menu;
		this.location = location;
		this.owner = owner;
		this.rating = rating;
		this.isAvailable = isAvailable;
	}

	public void displayRestaurantDetails() {
		System.out.println("Restaurant Name: " + name);
		System.out.println("Restaurant Location: " + location.getLatitude() + ", " + location.getLongitude());
		System.out.println("Owner Name: " + owner.getName());
		System.out.println("Owner Phone: " + owner.getPhone());
		System.out.println("Rating: " + rating);
	}

	public void displayMenu() {
		menu.displayMenu();
	}

	public void addMenu(Menu menu) {
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public RATINGS getRating() {
		return rating;
	}

	public boolean prepareFood(String orderId, Map<Dish, Integer> dishes) throws InterruptedException {
		System.out.println("Restaurant has accepted your order and starting to Prepare it: " + orderId);
		NotificationManager notificationManager = NotificationManager.getInstance();
		notificationManager.notify(orderId, "Your order has been accepted by the Restaurant: " + name + " and is being prepared");

		Thread.sleep(5000);

		notificationManager.notify(orderId, "Your order has been prepared and is ready for pickup from the restaurant: " + name);

		return true;
	}


}
