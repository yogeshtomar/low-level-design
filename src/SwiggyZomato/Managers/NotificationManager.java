package SwiggyZomato.Managers;

import SwiggyZomato.services.InterfaceNotificationSender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair {
	private String userId;
	private InterfaceNotificationSender notificationSender;

	public Pair(String userId, InterfaceNotificationSender notificationSender) {
		this.userId = userId;
		this.notificationSender = notificationSender;
	}

	public InterfaceNotificationSender getNotificationSender() {
		return notificationSender;
	}

	public String getUserId() {
		return userId;
	}
}

public class NotificationManager {
	private static volatile NotificationManager INSTANCE = null;

	private Map<String, List<Pair>> notificationSenderMap;
	private NotificationManager() {
		// Initialize the notification sender map
		notificationSenderMap = new HashMap<>();
	}

	public static NotificationManager getInstance() {
		if (INSTANCE == null) {
			synchronized (NotificationManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new NotificationManager();
				}
			}
		}
		return INSTANCE;
	}

	public void addNotificationSender(InterfaceNotificationSender notificationSender, String userId, String orderId) {
		// Add the notification sender to the list of notification senders
		if(!notificationSenderMap.containsKey(orderId)) {
			List<Pair> notificationSenderList = new ArrayList<>();
			notificationSenderList.add(new Pair(userId, notificationSender));
			notificationSenderMap.put(userId, notificationSenderList);
		}
	}

	public void removeNotificationSender(String orderId, String userId, InterfaceNotificationSender notificationSender) {
		// Remove the notification sender from the list of notification senders
		if(notificationSenderMap.containsKey(orderId)) {
			List<Pair> notificationSenderList = notificationSenderMap.get(orderId);
			for(int i = 0; i < notificationSenderList.size(); i++) {
				Pair pair = notificationSenderList.get(i);
				if(pair.getUserId().equals(userId) && pair.getNotificationSender().equals(notificationSender)) {
					notificationSenderList.remove(i);
					break;
				}
			}
		}
	}

	public void notify(String orderId, String message) {
		// Notify all the notification senders for the given order id
		if(notificationSenderMap.containsKey(orderId)) {
			List<Pair> notificationSenderList = notificationSenderMap.get(orderId);
			for(Pair pair : notificationSenderList) {
				pair.getNotificationSender().sendNotification(pair.getUserId(), message);
				System.out.println("Notification sent to: " + pair.getUserId() + " with message: " + message);
			}
		}
	}

	void notifyParticularUser(String userId, String message, InterfaceNotificationSender notificationSender) {
		// Notify the particular user
		notificationSender.sendNotification(userId, message);
	}
}
