package SwiggyZomato.Managers;

import SwiggyZomato.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
	private static volatile UserManager INSTANCE = null;
	private Map<String, User> userMap;

	private UserManager() {
		userMap = new HashMap<>();
	}

	public static UserManager getInstance() {
		if (INSTANCE == null) {
			synchronized (UserManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new UserManager();
				}
			}
		}
		return INSTANCE;
	}

	public void addUser(User user) {
		userMap.put(user.getPhone(), user);
	}

	public User getUser(String phone) {
		return userMap.get(phone);
	}
}
