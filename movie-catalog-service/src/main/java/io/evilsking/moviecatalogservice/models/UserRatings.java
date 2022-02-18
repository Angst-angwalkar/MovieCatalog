package io.evilsking.moviecatalogservice.models;

import java.util.List;

public class UserRatings {
	
	private List<Rating> userRating;
	
	public UserRatings() {}
	
	public UserRatings(List<Rating> userRating) {
		this.userRating = userRating;
	}
	
	public void setUserRating(List<Rating> userRatings) {
		this.userRating = userRatings;
	}
	
	public List<Rating> getUserRating() {
		return this.userRating;
	}
}
