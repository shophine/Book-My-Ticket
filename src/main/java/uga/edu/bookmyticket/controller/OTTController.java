package uga.edu.bookmyticket.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uga.edu.bookmyticket.dao.MovieDAO;
import uga.edu.bookmyticket.dao.OTTDAO;
import uga.edu.bookmyticket.entity.Movie;
import uga.edu.bookmyticket.entity.Ott;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Api(value = "bookmyticket")
@RestController
public class OTTController {
	
	@Autowired
	OTTDAO ottDAO;
	
	@CrossOrigin
	@GetMapping(value = "/ott", produces = "application/json")
	public List<Ott> getListOfOTTMovies(){
		List<Ott> ottMovies = new ArrayList<>();
		try {
			ottMovies = ottDAO.findAll();
			for (Ott movie: ottMovies) {
				movie.printOTTEntity();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Something went wrong", e);
		}
	return ottMovies;
		
	}





}
