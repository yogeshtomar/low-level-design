package OlaUber.strategies;

import OlaUber.enums.Rating;
import OlaUber.enums.RatingUtil;
import OlaUber.models.TripMetadata;

public class RatingsBasedPricingStrategy implements PricingStrategy{
	@Override
	public double calculateFare(TripMetadata tripMetadata) {
		System.out.println("RatingsBasedPricingStrategy.calculateFare");
		Rating rating = tripMetadata.getRiderRating();
		double price = RatingUtil.isHighRating(rating) ? 55.0 : 65.0;
		System.out.println("Based on the rider's rating: " + RatingUtil.ratingToString(rating) + "the price of the trip is: " + price);
		return price;
	}
}
