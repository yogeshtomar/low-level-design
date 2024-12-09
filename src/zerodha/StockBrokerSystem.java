package zerodha;

import zerodha.enums.ORDER_TYPE;
import zerodha.enums.STOCK_EXCHANGE;
import zerodha.enums.TRANSACTION_TYPE;
import zerodha.managers.OrderManager;
import zerodha.managers.OrderProcessor;
import zerodha.models.Order;
import zerodha.models.OrderMetaData;
import zerodha.models.Stock;
import zerodha.models.User;

import java.util.Date;

public class StockBrokerSystem {
	public static void main(String[] args) {
		System.out.println("Stock Broker System");
		User user1 = new User("user1", 10000);
		OrderProcessor orderProcessor = OrderProcessor.getOrderProcessor();
		Stock appl = new Stock("APPL", 10, STOCK_EXCHANGE.BSE);
		OrderMetaData orderMetaData1 = new OrderMetaData(TRANSACTION_TYPE.BUY, ORDER_TYPE.MARKET,
				STOCK_EXCHANGE.BSE, 1000, 10, appl, user1, new Date(2024, 8, 30));
		int order1 = orderProcessor.placeOrder(orderMetaData1);
		OrderManager orderManager = OrderManager.getOrderManager();
		Order order = orderManager.getOrder(order1);
		System.out.println(order);
	}
}
