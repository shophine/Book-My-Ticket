package uga.edu.bookmyticket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import uga.edu.bookmyticket.dao.MovieDAO;
import uga.edu.bookmyticket.entity.Movie;

@CrossOrigin
@Api(value = "bookmyticket")
@RestController
public class MovieController {
	
	@Autowired
	MovieDAO movieDAO;
	
	@CrossOrigin
	@GetMapping(value = "/movies", produces = "application/json")
	public List<Movie> getListOfMovies(){
		List<Movie> movies = new ArrayList<>();
		try {
			movies = movieDAO.findAll();
			for (Movie movie: movies) {
				movie.printMovieEntity();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Something went wrong", e);
		}
	return movies;
		
	}



}
