package zerodha.strategies;

import zerodha.enums.ORDER_TYPE;
import zerodha.services.LimitOrderFactory;
import zerodha.services.MarketOrderFactory;
import zerodha.services.OrderFactory;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
	private static final Map<ORDER_TYPE, OrderFactory> strategies = new HashMap<>();

	static {
		strategies.put(ORDER_TYPE.MARKET, new MarketOrderFactory());
		strategies.put(ORDER_TYPE.LIMIT, new LimitOrderFactory());
	}

	public static OrderFactory getStrategy(ORDER_TYPE orderType) {
		return strategies.get(orderType);
	}
}
