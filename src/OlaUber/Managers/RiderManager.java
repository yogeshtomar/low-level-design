package OlaUber.Managers;

import OlaUber.models.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {
	private static volatile RiderManager INSTANCE = null;
	Map<String, Rider> riderMap = null;

	private RiderManager() {
		riderMap = new HashMap<>();
	}

	public static RiderManager getInstance() {
		if (INSTANCE == null) {
			synchronized (RiderManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new RiderManager();
				}
			}
		}
		return  INSTANCE;
	}

	public void addRider(Rider rider) {
		riderMap.put(rider.getPhoneNo(), rider);
	}

	public Rider getRider(String phoneNo) {
		return riderMap.get(phoneNo);
	}
}
