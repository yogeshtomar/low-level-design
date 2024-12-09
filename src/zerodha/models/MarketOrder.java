package zerodha.models;

import zerodha.enums.ORDER_STATUS;
import zerodha.enums.ORDER_TYPE;
import zerodha.enums.STOCK_EXCHANGE;
import zerodha.enums.TRANSACTION_TYPE;

public class MarketOrder extends Order {
	double marketPrice;
	public MarketOrder(int orderId, TRANSACTION_TYPE transactionType, ORDER_TYPE orderType, STOCK_EXCHANGE stockExchange, double price, int quantity, Stock stock) {
		super(orderId, transactionType, orderType, stockExchange, price, quantity, stock);
	}

	public double getMarketPrice() {
		return marketPrice;
	}




	public void setMarketPrice(double marketPrice) {
		this.price = marketPrice;
		this.marketPrice = marketPrice;
	}

	@Override
	public void setStatus(ORDER_STATUS status) {
		this.orderStatus = status;
	}
}
