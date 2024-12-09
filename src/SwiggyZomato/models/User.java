package SwiggyZomato.models;

public class User {
	private String name;
	private String email;
	private String phone;
	private Location location;

	public User(String name, String email, String phone, Location location) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public Location getLocation() {
		return location;
	}
}
