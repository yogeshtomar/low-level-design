package zerodha.managers;

import zerodha.models.OrderMetaData;

public interface OrderValidator {
	boolean validateOrder(OrderMetaData orderMetaData);
}
