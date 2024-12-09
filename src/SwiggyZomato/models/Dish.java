package SwiggyZomato.models;

import SwiggyZomato.enums.CUISINE;

import java.util.ArrayList;
import java.util.List;

public class Dish {
	private String name;
	private String description;
	private double price;
	private List<String> images;
	private CUISINE cuisine;

	private List<DishAddOn> dishAddOns;

	public Dish(String name, String description, double price, CUISINE cuisine, List<String> images) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.images = images;
		this.cuisine = cuisine;
		this.dishAddOns = new ArrayList<>();
	}

	public double getPrice() {
		double totalPrice = price;
		for(DishAddOn dishAddOn : dishAddOns) {
			totalPrice += dishAddOn.getPrice();
		}
		return totalPrice;
	}
	public void addAddOns(DishAddOn dishAddOns) {
		this.dishAddOns.add(dishAddOns);
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public CUISINE getCuisine() {
		return cuisine;
	}

	public void displayDish() {
		System.out.println(name + " " + description + " " + price + " " + cuisine);
	}
}
