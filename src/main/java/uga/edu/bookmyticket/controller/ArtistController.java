package uga.edu.bookmyticket.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import uga.edu.bookmyticket.dao.ArtistDAO;
import uga.edu.bookmyticket.dao.MovieDAO;
import uga.edu.bookmyticket.entity.Artist;
import uga.edu.bookmyticket.entity.Movie;

@CrossOrigin
@Api(value = "bookmyticket")
@RestController
public class ArtistController {

    @Autowired
    ArtistDAO artistDAO;

    @CrossOrigin
    @GetMapping(value = "/artist", produces = "application/json")
    public List<Artist> getListOfArtist(){
        List<Artist> artists = new ArrayList<>();
        try {
            artists = artistDAO.findAll();
            for (Artist artist: artists) {
                artist.printArtistEntity(artist);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Something went wrong", e);
        }
        return artists;

    }

}
