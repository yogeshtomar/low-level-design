package zerodha.services;
import zerodha.models.MarketOrder;
import zerodha.models.Order;
import zerodha.models.OrderMetaData;
import zerodha.util.GenerateId;

public class MarketOrderFactory implements OrderFactory {
	@Override
	public Order createOrder(OrderMetaData orderMetadata) {
		System.out.println("Creating Market Order");
		int orderId = GenerateId.getId();
		Order order = new MarketOrder(orderId, orderMetadata.getTransactionType(), orderMetadata.getOrderType(),
				orderMetadata.getStockExchange(), orderMetadata.getPrice(), orderMetadata.getQuantity(), orderMetadata.getStock());
		System.out.println("Market Order Created");

		return order;
	}
}
