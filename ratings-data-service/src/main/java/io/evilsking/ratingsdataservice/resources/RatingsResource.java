package io.evilsking.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.evilsking.ratingsdataservice.models.Rating;
import io.evilsking.ratingsdataservice.models.UserRatings;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 5);
	}
	
	@RequestMapping("users/{userId}")
	public UserRatings getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 5),
				new Rating("5678", 4)
				);
		UserRatings userRatings = new UserRatings();
		userRatings.setUserRating(ratings);
		return userRatings;
	}

}
