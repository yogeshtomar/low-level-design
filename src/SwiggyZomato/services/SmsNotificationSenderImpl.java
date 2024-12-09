package SwiggyZomato.services;

public class SmsNotificationSenderImpl implements InterfaceNotificationSender{
	@Override
	public void sendNotification(String userId, String message) {
		System.out.println("Sending SMS notification to user: " + userId + " with message: " + message);
	}
}
