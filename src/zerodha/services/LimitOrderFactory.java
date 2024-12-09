package zerodha.services;

import zerodha.models.LimitOrder;
import zerodha.models.Order;
import zerodha.models.OrderMetaData;
import zerodha.util.GenerateId;

public class LimitOrderFactory implements OrderFactory {
	@Override
	public Order createOrder(OrderMetaData orderMetadata) {
		System.out.println("Creating Limit Order");
		int orderId = GenerateId.getId();
		Order order = new LimitOrder(orderId, orderMetadata.getTransactionType(), orderMetadata.getOrderType(),
				orderMetadata.getStockExchange(), orderMetadata.getPrice(), orderMetadata.getQuantity(), orderMetadata.getStock());
		System.out.println("Limit Order Created");
		return order;
	}
}
