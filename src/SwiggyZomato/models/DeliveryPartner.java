package SwiggyZomato.models;

public class DeliveryPartner implements IPartner {
	private String name;
	private String phone;
	private Location currentLocation;

	public DeliveryPartner(String name, String phone, Location location) {
		this.name = name;
		this.phone = phone;
		this.currentLocation = location;
	}

	public String getPhone() {
		return phone;
	}

	@Override
	public void performKyc() {
		System.out.println("Performing KYC for Delivery Partner");
	}

	@Override
	public String getName() {
		return name;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location location) {
		this.currentLocation = location;
	}

	public void performDeliver(String orderId, DeliveryMetaData deliveryMetadata) throws InterruptedException {
		System.out.println("Delivery Partner has picked up the order: " + orderId + " and is on the way to deliver it");
	}
}
