package zerodha.models;

import java.util.ArrayList;
import java.util.List;

public class WatchList {
	String name;
	List<Stock> stocks;

	public WatchList(String name) {
		this.name = name;
		this.stocks = new ArrayList<>();
	}
	public void addStock(Stock stock) {
		stocks.add(stock);
	}

	public void removeStock(Stock stock) {
		stocks.remove(stock);
	}
}
