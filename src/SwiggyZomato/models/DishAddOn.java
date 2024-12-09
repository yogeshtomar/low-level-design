package SwiggyZomato.models;

import java.util.List;

public class DishAddOn {
	private String name;
	private String description;
	private double price;
	private List<String> images;

	public DishAddOn(String name, String description, double price, List<String> images) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.images = images;
	}

	public double getPrice() {
		return price;
	}
}
