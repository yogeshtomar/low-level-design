package zerodha.services;
import zerodha.models.Order;
import zerodha.models.OrderMetaData;

public interface OrderFactory {
	Order createOrder(OrderMetaData orderMetadata);
}
