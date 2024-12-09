package SwiggyZomato.models;

public class RestaurantOwner implements IPartner {
	private String name;
	private String email;
	private String phone;
	private Location location;

	public RestaurantOwner(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	@Override
	public void performKyc() {
		System.out.println("Performing KYC for Restaurant Owner");
	}

	@Override
	public String getName() {
		return name;
	}
}
