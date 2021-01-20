package uga.edu.bookmyticket.view.bean;

public class BookTicketsFromUser {
    String userSSN;
    String showTime;
    String movieName;
    int theater_id;
    String theater_name;
    String state;
    String country;

    public String getUserSSN() {
        return userSSN;
    }

    public void setUserSSN(String userSSN) {
        this.userSSN = userSSN;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BookTicketsFromUser(String userSSN, String showTime, String movieName, int theater_id, String theater_name, String state, String country) {
        this.userSSN = userSSN;
        this.showTime = showTime;
        this.movieName = movieName;
        this.theater_id = theater_id;
        this.theater_name = theater_name;
        this.state = state;
        this.country = country;
    }

    public BookTicketsFromUser(String userSSN) {
        this.userSSN = userSSN;
    }
}
