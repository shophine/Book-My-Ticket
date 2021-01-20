package uga.edu.bookmyticket;

public class NowShowingDetailsForUser {
    int movie_id;
    String movie_name;

    int theater_id;
    String theater_name;
    String theater_location;

    String show_time;

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public String getTheater_location() {
        return theater_location;
    }

    public void setTheater_location(String theater_location) {
        this.theater_location = theater_location;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public NowShowingDetailsForUser(int movie_id, String movie_name, int theater_id, String theater_name, String theater_location, String show_time) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.theater_id = theater_id;
        this.theater_name = theater_name;
        this.theater_location = theater_location;
        this.show_time = show_time;
    }

    public NowShowingDetailsForUser() {
    }
}
