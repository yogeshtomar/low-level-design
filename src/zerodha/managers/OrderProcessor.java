package zerodha.managers;

import zerodha.models.Order;
import zerodha.models.OrderMetaData;
import zerodha.services.OrderFactory;
import zerodha.strategies.StrategyContext;
import zerodha.strategies.StrategyFactory;

public class OrderProcessor {
	private static volatile OrderProcessor INSTANCE;
	private OrderValidator orderValidator = DefaultValidator.getInstance();
	private OrderManager orderManager = OrderManager.getOrderManager();

	private OrderFactory orderFactory;
	private StrategyContext strategyContext = new StrategyContext();

	private OrderProcessor() {

	}
	public static OrderProcessor getOrderProcessor() {
		if(INSTANCE == null)  {
			synchronized (OrderProcessor.class) {
				if(INSTANCE == null) {
					INSTANCE = new OrderProcessor();
				}
			}
		}
		return INSTANCE;
	}

	public int placeOrder(OrderMetaData orderMetaData) {
		Order order = null;
		if (orderValidator.validateOrder(orderMetaData)) {
			orderFactory = StrategyFactory.getStrategy(orderMetaData.getOrderType());
			strategyContext.setOrderFactory(orderFactory);
			order = orderFactory.createOrder(orderMetaData);
			orderManager.addOrder(order);
			return order.getOrderId();
		}
		else {
			return -1;
		}
	}
}
