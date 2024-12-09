package zerodha.models;

import zerodha.enums.STOCK_EXCHANGE;

public class Stock {
	private String name;
	private double price;
	private STOCK_EXCHANGE stockExchange;

	public Stock(String name, double price, STOCK_EXCHANGE stockExchange) {
		this.name = name;
		this.price = price;
		this.stockExchange = stockExchange;
	}

	public  String toString() {
		return "Stock Name: " + name + " Price: " + price + " Stock Exchange: " + stockExchange;
	}
}
