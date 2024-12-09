package OlaUber.enums;

public class RatingUtil {
	public static String ratingToString(Rating rating) {
		switch (rating) {
			case ONE_STAR:
				return "one star";
			case TWO_STAR:
				return "two star";
			case THREE_STAR:
				return "three star";
			case FOUR_STAR:
				return "four star";
			case FIVE_STAR:
				return "five star";
			default:
				return "unassigned";
		}
	}

	public static boolean isHighRating(Rating rating) {
		return rating == Rating.FIVE_STAR || rating == Rating.FOUR_STAR;
	}
}
