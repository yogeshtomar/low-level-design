package SwiggyZomato.strategies;

import SwiggyZomato.models.DeliveryMetaData;
import SwiggyZomato.models.DeliveryPartner;

import java.util.List;

public interface InterfaceDeliveryPartnerMatchingStrategy {
	List<DeliveryPartner> matchDeliveryPartner(DeliveryMetaData deliveryMetaData);
}
