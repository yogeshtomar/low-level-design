package SwiggyZomato.services;

public class PushNotificationSenderImpl implements InterfaceNotificationSender{
	@Override
	public void sendNotification(String userId, String message) {
		System.out.println("Sending push notification to user: " + userId + " with message: " + message);
	}
}
