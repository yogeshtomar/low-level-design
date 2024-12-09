package zerodha.models;

import zerodha.enums.ORDER_STATUS;
import zerodha.enums.ORDER_TYPE;
import zerodha.enums.STOCK_EXCHANGE;
import zerodha.enums.TRANSACTION_TYPE;

import java.util.Date;

public class OrderMetaData {
	private TRANSACTION_TYPE transactionType;
	private ORDER_TYPE orderType;
	private STOCK_EXCHANGE stockExchange;
	private double price;
	private int quantity;
	private Stock stock;
	private ORDER_STATUS orderStatus;
	private Date orderDateTime;
	private User user;
	private Date goodTillDate;

	public OrderMetaData( TRANSACTION_TYPE transactionType, ORDER_TYPE orderType, STOCK_EXCHANGE stockExchange, double price, int quantity, Stock stock, User user, Date goodTillDate) {
		this.transactionType = transactionType;
		this.orderType = orderType;
		this.stockExchange = stockExchange;
		this.price = price;
		this.quantity = quantity;
		this.stock = stock;
		this.orderStatus = ORDER_STATUS.OPEN;
		this.orderDateTime = new Date();
		this.user = user;
		this.goodTillDate = goodTillDate;
	}

	public TRANSACTION_TYPE getTransactionType() {
		return transactionType;
	}
	public ORDER_TYPE getOrderType() {
		return orderType;
	}
	public STOCK_EXCHANGE getStockExchange() {
		return stockExchange;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public Stock getStock() {
		return stock;
	}
	public ORDER_STATUS getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(ORDER_STATUS orderStatus) {
		this.orderStatus = orderStatus;
	}
}
