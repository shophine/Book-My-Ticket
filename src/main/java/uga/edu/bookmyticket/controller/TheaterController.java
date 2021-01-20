package uga.edu.bookmyticket.controller;

        import io.swagger.annotations.Api;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.server.ResponseStatusException;
        import uga.edu.bookmyticket.NowShowingDetailsForUser;
        import uga.edu.bookmyticket.dao.MovieDAO;
        import uga.edu.bookmyticket.dao.NowShowingDAO;
        import uga.edu.bookmyticket.dao.TheaterDAO;
        import uga.edu.bookmyticket.entity.Movie;
        import uga.edu.bookmyticket.entity.NowShowing;
        import uga.edu.bookmyticket.entity.Theater;
        import uga.edu.bookmyticket.view.bean.TheaterLocationFromUser;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

@CrossOrigin
@Api(value = "bookmyticket")
@RestController
public class TheaterController {

    @Autowired
    TheaterDAO theaterDAO;
    @Autowired
    NowShowingDAO nowShowingDAO;
    @Autowired
    MovieDAO movieDAO;

    @CrossOrigin
    @GetMapping(value = "/getTheatreLocations", produces = "application/json")
    public List<Theater> getListOfOTTMovies(){
        List<Theater> theaters = new ArrayList<>();
        try {
            theaters = theaterDAO.findAll();
            for (Theater theater: theaters) {
                //theater.printTheaterEntity();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Something went wrong", e);
        }
        return theaters;

    }


    @RequestMapping(method = RequestMethod.POST, value = "/getMoviesAtTheater", produces="application/json")
    public List<NowShowingDetailsForUser> getMoviesAtTheater(@RequestBody TheaterLocationFromUser userInput) {
        List<NowShowing> nowShowingList = new ArrayList<>();
        List <NowShowingDetailsForUser> nowShowingDetailsForUserList = new ArrayList<>();
        Movie movie = null;
        Theater theater = null;
        try {
             nowShowingList = nowShowingDAO.getNowShowingDetailsByID(userInput.getTheater_id());

            int movie_id;
            String movie_name;
            int theater_id;
            String theater_name;
            String theater_location;
            String show_time;

            for (NowShowing no: nowShowingList) {
                movie_id = no.getMovies_id();
                theater_id = no.getTheater_id();
                show_time = no.getShow_time();

                movie = movieDAO.getMovieDetailsByID(movie_id);
                theater = theaterDAO.getTheaterDetailsByID(theater_id);

                movie_name = movie.getName();
                theater_name = theater.getTheater_name();
                theater_location = theater.getTheater_location();

                NowShowingDetailsForUser nowShowingDetailsForUserObj = new NowShowingDetailsForUser(movie_id, movie_name, theater_id, theater_name, theater_location, show_time);

                nowShowingDetailsForUserList.add(nowShowingDetailsForUserObj);

            }


        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Something went wrong", e);
        }
        return nowShowingDetailsForUserList;

    }


    @CrossOrigin
    @GetMapping(value = "/getCountryFromTheatreLocations", produces = "application/json")
    public List<Theater> getCountryFromTheatreLocations(){
        List<Theater> theaters = new ArrayList<>();
        try {
            theaters = theaterDAO.findAll();
            for (Theater theater: theaters) {
                //theater.printTheaterEntity();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Something went wrong", e);
        }
        return theaters;

    }







}

