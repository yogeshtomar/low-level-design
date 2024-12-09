package SwiggyZomato.models;

public class DeliveryMetaData {
	private String orderId;
	private Location deliveryLocation;
	private Location restaurantLocation;

	public DeliveryMetaData(String orderId, Location deliveryLocation, Location restaurantLocation) {
		this.orderId = orderId;
		this.deliveryLocation = deliveryLocation;
		this.restaurantLocation = restaurantLocation;
	}

	public Location getDeliveryLocation() {
		return deliveryLocation;
	}

	public Location getRestaurantLocation() {
		return restaurantLocation;
	}
}
