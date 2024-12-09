package zerodha.models;

import zerodha.enums.ORDER_STATUS;
import zerodha.enums.ORDER_TYPE;
import zerodha.enums.STOCK_EXCHANGE;
import zerodha.enums.TRANSACTION_TYPE;

import java.util.Date;

public abstract class Order {
	int orderId;
	TRANSACTION_TYPE transactionType;
	ORDER_TYPE orderType;
	STOCK_EXCHANGE stockExchange;
	double price;
	int quantity;
	Stock stock;

	ORDER_STATUS orderStatus;
	Date orderDateTime;

	public Order(int orderId, TRANSACTION_TYPE transactionType, ORDER_TYPE orderType, STOCK_EXCHANGE stockExchange, double price, int quantity, Stock stock) {
		this.orderId = orderId;
		this.transactionType = transactionType;
		this.orderType = orderType;
		this.stockExchange = stockExchange;
		this.price = price;
		this.quantity = quantity;
		this.stock = stock;
		this.orderStatus = ORDER_STATUS.OPEN;
		this.orderDateTime = new Date();
	}
	public abstract void setStatus(ORDER_STATUS status);

	public int getOrderId() {
		return orderId;
	}

	public String toString() {
		return "Order ID: " + orderId + " Transaction Type: " + transactionType + " Order Type: " + orderType + " Stock Exchange: " + stockExchange + " Price: " + price + " Quantity: " + quantity + " Stock: " + stock.toString() + " Order Status: " + orderStatus + " Order Date Time: " + orderDateTime;
	}
}
