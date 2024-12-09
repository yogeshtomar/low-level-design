package zerodha.managers;

import zerodha.models.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
	private static volatile OrderManager INSTANCE;
	private Map<Integer, Order> orders;
	private OrderManager() {
		this.orders = new HashMap<>();
	}

	public static OrderManager getOrderManager() {
		if (INSTANCE == null) {
			synchronized (OrderManager.class) {
				if (INSTANCE == null) {
					INSTANCE = new OrderManager();
				}
			}
		}
		return INSTANCE;
	}

	public void addOrder(Order order) {
		orders.put(order.getOrderId(), order);
	}

	public Order getOrder(int orderId) {
		return orders.get(orderId);
	}

}
