package uga.edu.bookmyticket.view.bean;

public class NowShowingMoviesAtTheater {
    String movieName;
    int movieRating;
    String showTime;
    String theaterName;
    String theaterState;
    String theaterCountry;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterState() {
        return theaterState;
    }

    public void setTheaterState(String theaterState) {
        this.theaterState = theaterState;
    }

    public String getTheaterCountry() {
        return theaterCountry;
    }

    public void setTheaterCountry(String theaterCountry) {
        this.theaterCountry = theaterCountry;
    }

    public NowShowingMoviesAtTheater(String movieName, int movieRating, String showTime, String theaterName, String theaterState, String theaterCountry) {
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.showTime = showTime;
        this.theaterName = theaterName;
        this.theaterState = theaterState;
        this.theaterCountry = theaterCountry;
    }

    public NowShowingMoviesAtTheater() {
    }
}
