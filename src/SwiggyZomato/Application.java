package SwiggyZomato;

import SwiggyZomato.Managers.DeliveryPartnerManager;
import SwiggyZomato.Managers.OrderManager;
import SwiggyZomato.Managers.RestaurantManager;
import SwiggyZomato.enums.CUISINE;
import SwiggyZomato.enums.RATINGS;
import SwiggyZomato.models.DeliveryPartner;
import SwiggyZomato.models.Dish;
import SwiggyZomato.models.DishAddOn;
import SwiggyZomato.models.Menu;
import SwiggyZomato.models.Order;
import SwiggyZomato.models.Restaurant;
import SwiggyZomato.models.RestaurantOwner;
import SwiggyZomato.models.Location;
import SwiggyZomato.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
	public static void main(String[] args) {
		System.out.println("Welcome to SwiggyZomato");
		// Chinese Restaurant
		RestaurantOwner chineseRestaurantOwner = new RestaurantOwner("Chinese Restaurant Owner",
				"chinese@gmail.com", "1111111111");
		Dish firedRice = new Dish("Fired Rice", "fried premium basmati rice with garlic and veggies", 10.0, CUISINE.CHINESE, new ArrayList<>());
		Dish noodles = new Dish("Noodles", "noodles with veggies and sauces", 12.0, CUISINE.CHINESE, new ArrayList<>());
		noodles.addAddOns(new DishAddOn("premium sauce", "home madesauce", 12.0, new ArrayList<>()));
		Dish manchurian = new Dish("Manchurian", "manchurian balls with sauce", 15.0, CUISINE.CHINESE, new ArrayList<>());
		Dish springRolls = new Dish("Spring Rolls", "spring rolls with veggies", 8.0, CUISINE.CHINESE, new ArrayList<>());

		List<Dish> chineseDishes = new ArrayList<>();
		chineseDishes.add(firedRice);
		chineseDishes.add(noodles);
		chineseDishes.add(manchurian);
		chineseDishes.add(springRolls);
		Menu chineeseMenu = new Menu(chineseDishes);

		Restaurant chineseRestaurant = new Restaurant("Chinese Restaurant", chineeseMenu,
				new Location(20, 10), chineseRestaurantOwner, true, RATINGS.FOUR_STAR);
		chineseRestaurant.displayRestaurantDetails();
		chineseRestaurant.displayMenu();

		// Italian Restaurant
		RestaurantOwner italianRestaurantOwner = new RestaurantOwner("Italian Restaurant Owner",
				"italian@gmail.com", "12344444444");
		Dish pasta = new Dish("Pasta", "pasta with white sauce", 10.0, CUISINE.ITALIAN, new ArrayList<>());
		Dish pizza = new Dish("Pizza", "pizza with cheese and veggies", 12.0, CUISINE.ITALIAN, new ArrayList<>());
		Dish garlicBread = new Dish("Garlic Bread", "garlic bread with cheese", 15.0, CUISINE.ITALIAN, new ArrayList<>());
		Dish lasagna = new Dish("Lasagna", "lasagna with cheese and veggies", 8.0, CUISINE.ITALIAN, new ArrayList<>());

		List<Dish> italianDishes = new ArrayList<>();
		italianDishes.add(pasta);
		italianDishes.add(pizza);
		italianDishes.add(garlicBread);
		italianDishes.add(lasagna);
		Menu italianMenu = new Menu(italianDishes);

		Restaurant italianRestaurant = new Restaurant("Italian Restaurant", italianMenu,
				new Location(13, 14), italianRestaurantOwner, true, RATINGS.FIVE_STAR);

		italianRestaurant.displayRestaurantDetails();
		italianRestaurant.displayMenu();

		// North Indian Restaurant
		RestaurantOwner northIndianRestaurantOwner = new RestaurantOwner("North Indian Restaurant Owner",
				"northIndia@gmail.com", "011-12345678");
		Dish butterChicken = new Dish("Butter Chicken", "butter chicken with butter naan", 10.0, CUISINE.NORTH_INDIAN, new ArrayList<>());
		Dish rajmaChawal = new Dish("Rajma Chawal", "rajma with rice", 12.0, CUISINE.NORTH_INDIAN, new ArrayList<>());
		Dish choleBhature = new Dish("Chole Bhature", "chole bhature with salad", 15.0, CUISINE.NORTH_INDIAN, new ArrayList<>());
		Dish alooParatha = new Dish("Aloo Paratha", "aloo paratha with curd", 8.0, CUISINE.NORTH_INDIAN, new ArrayList<>());

		List<Dish> northIndianDishes = new ArrayList<>();
		northIndianDishes.add(butterChicken);
		northIndianDishes.add(rajmaChawal);
		northIndianDishes.add(choleBhature);
		northIndianDishes.add(alooParatha);
		Menu northIndianMenu = new Menu(northIndianDishes);

		Restaurant northIndianRestaurant = new Restaurant("North Indian Restaurant", northIndianMenu,
				new Location(15, 16), northIndianRestaurantOwner, true, RATINGS.FOUR_STAR);

		northIndianRestaurant.displayRestaurantDetails();
		northIndianRestaurant.displayMenu();

		RestaurantManager restaurantManager = RestaurantManager.getInstance();
		restaurantManager.addRestaurant(chineseRestaurant);
		restaurantManager.addRestaurant(italianRestaurant);
		restaurantManager.addRestaurant(northIndianRestaurant);

		DeliveryPartner alpha = new DeliveryPartner("Alpha", "12340001", new Location(10, 10));
		DeliveryPartner beta = new DeliveryPartner("Beta", "12340002", new Location(13, 13));
		DeliveryPartner gamma = new DeliveryPartner("Gamma", "12340003", new Location(18, 20));

		DeliveryPartnerManager deliveryPartnerManager = DeliveryPartnerManager.getInstance();
		deliveryPartnerManager.addDeliveryPartner(alpha);
		deliveryPartnerManager.addDeliveryPartner(beta);
		deliveryPartnerManager.addDeliveryPartner(gamma);

		User yogesh = new User("yogesh", "yogesh@gmail.com", "123450001", new Location(1, 1));
		User subhash = new User("subhash", "subhash@gmail.com", "123450002", new Location(1, 2));
		User mukul = new User("mukul", "mukul@gmail.com", "123450003", new Location(1, 3));

		Map<Dish, Integer> order1Dishes = Map.of(firedRice, 2, noodles, 1);
		Map<Dish, Integer> order2Dishes = Map.of(pasta, 2, pizza, 1);
		Map<Dish, Integer> order3Dishes = Map.of(butterChicken, 2, rajmaChawal, 1);
		// Order from Chinese Restaurant
		OrderManager orderManager = OrderManager.getInstance();
		try {
			orderManager.createOrder("order1", new Order(subhash, chineseRestaurant, order1Dishes, "DISCOUNT1", "PAYMENT1"));
			orderManager.createOrder("order2", new Order(yogesh, italianRestaurant, order2Dishes, "DISCOUNT2", "PAYMENT2"));
			orderManager.createOrder("order3", new Order(mukul, northIndianRestaurant, order3Dishes, "DISCOUNT3", "PAYMENT3"));

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
