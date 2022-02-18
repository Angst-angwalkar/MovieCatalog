package io.evilsking.moviecatalogservice.resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.evilsking.moviecatalogservice.models.Movie;
import io.evilsking.moviecatalogservice.models.MovieCatalog;
import io.evilsking.moviecatalogservice.models.Rating;
import io.evilsking.moviecatalogservice.models.UserRatings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
//	Bean created in application.java and autowired
//	Bean -> producer | Autowired -> consumer
	
//	for synchronous
	@Autowired
	RestTemplate restTemplate;
	
//  for asynchronous
//	@Autowired
//	WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<MovieCatalog> getCatalog(@PathVariable("userId")  String userId){

		UserRatings userRatings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRatings.class);
		
		System.out.println(SpringVersion.getVersion());
		return userRatings.getUserRating().stream().map(rating -> {
//			synchronous way -> RestTemplate
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			
//			asynchronous way -> WebClient
//			Movie movie = webClientBuilder.build()
//					.get()
//					.uri("http://localhost:8082/movies/" + rating.getMovieId())
//					.retrieve()
//					.bodyToMono(Movie.class)
//					.block();
			
			return new MovieCatalog(movie.getMovieName(), "Bullshit", rating.getRating());
		}).collect(Collectors.toList());
		
//		return Collections.singletonList(
//				new MovieCatalog("Titanic", "Two lovers, One Drowns, Chutiya", 3));
		
	}
}
