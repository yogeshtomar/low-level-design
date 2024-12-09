package SwiggyZomato.models;

import java.util.List;

public class Menu {
	private List<Dish> dishes;

	public Menu(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public void addDish(Dish dish) {
		this.dishes.add(dish);
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void displayMenu() {
		for(Dish dish : dishes) {
			dish.displayDish();
		}
	}
}
