package OlaUber.Managers;

import OlaUber.models.Driver;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {
	private static volatile DriverManager INSTANCE = null;
	Map<String, Driver> driverMap = null;

	private DriverManager() {
		driverMap = new HashMap<>();
	}

	public static DriverManager getInstance() {
		if (INSTANCE == null) {
			synchronized (DriverManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new DriverManager();
				}
			}
		}
		return  INSTANCE;
	}

	public void addDriver(Driver driver) {
		driverMap.put(driver.getPhoneNo(), driver);
	}

	public Driver getDriver(String phoneNo) {
		return driverMap.get(phoneNo);
	}

	public Map<String, Driver> getDriverMap() {
		return driverMap;
	}

}
