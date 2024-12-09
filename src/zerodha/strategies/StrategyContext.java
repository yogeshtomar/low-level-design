package zerodha.strategies;

import zerodha.models.OrderMetaData;
import zerodha.services.OrderFactory;

public class StrategyContext {
	private OrderFactory orderFactory;

	public void setOrderFactory(OrderFactory orderFactory) {
		this.orderFactory = orderFactory;
	}

	public void executeStrategy(OrderMetaData orderMetaData) {
		orderFactory.createOrder(orderMetaData);
	}
}
