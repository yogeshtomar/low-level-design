package zerodha.managers;

import zerodha.models.OrderMetaData;

public class DefaultValidator implements OrderValidator {
	private static volatile DefaultValidator INSTANCE;
	private DefaultValidator() {}

	public static DefaultValidator getInstance() {
		if (INSTANCE == null) {
			synchronized (DefaultValidator.class) {
				if (INSTANCE == null) {
					INSTANCE = new DefaultValidator();
				}
			}
		}
		return INSTANCE;
	}

	@Override
	public boolean validateOrder(OrderMetaData orderMetaData) {
		System.out.println("Validating Order");
		return true;
	}
}
