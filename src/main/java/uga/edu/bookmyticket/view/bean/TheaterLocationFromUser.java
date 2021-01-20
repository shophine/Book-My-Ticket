package uga.edu.bookmyticket.view.bean;

public class TheaterLocationFromUser {
    int theater_id;
    String theater_location;

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public String getTheater_location() {
        return theater_location;
    }

    public void setTheater_location(String theater_location) {
        this.theater_location = theater_location;
    }

    public TheaterLocationFromUser(int theater_id, String theater_location) {
        this.theater_id = theater_id;
        this.theater_location = theater_location;
    }

    public TheaterLocationFromUser() {
    }
}

