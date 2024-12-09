package zerodha.util;

public class GenerateId {
	private static int id = 1000000;

	public static int getId() {
		return id++;
	}
}
