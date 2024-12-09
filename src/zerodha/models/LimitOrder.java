package zerodha.models;

import zerodha.enums.ORDER_STATUS;
import zerodha.enums.ORDER_TYPE;
import zerodha.enums.STOCK_EXCHANGE;
import zerodha.enums.TRANSACTION_TYPE;

import java.util.Date;

public class LimitOrder extends Order {
	private double limitPrice;

	public LimitOrder(int orderId, TRANSACTION_TYPE transactionType, ORDER_TYPE orderType, STOCK_EXCHANGE stockExchange, double price, int quantity, Stock stock) {
		super(orderId, transactionType, orderType, stockExchange, price, quantity, stock);
		this.limitPrice = price;
	}

	public double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}

	@Override
	public void setStatus(ORDER_STATUS status) {
		this.orderStatus = status;
	}
}
