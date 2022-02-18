package io.evilsking.movieinfoservice.resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.evilsking.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResources {
	
	@RequestMapping("/{movieId}")
	public Movie getMovieDetails(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Test Name");
	}
}