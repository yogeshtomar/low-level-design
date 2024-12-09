package zerodha.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class User{
	private String userId;
	private double availableBalance;

	public User(String userId, double availableBalance) {
		this.userId = userId;
		this.availableBalance = availableBalance;
		watchLists = new ArrayList<>();
	}

	private List<WatchList> watchLists;
	public boolean resetPassword(String newPassword) {
		// definitiom
		return true;
	}
}
