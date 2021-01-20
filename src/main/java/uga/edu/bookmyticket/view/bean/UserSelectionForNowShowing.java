package uga.edu.bookmyticket.view.bean;

public class UserSelectionForNowShowing {
    String country;
    String state;
    int theater_id;
    String theater_name;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public UserSelectionForNowShowing(String country, String state, int theater_id, String theater_name) {
        this.country = country;
        this.state = state;
        this.theater_id = theater_id;
        this.theater_name = theater_name;
    }

    public UserSelectionForNowShowing(String country) {
        this.country = country;
    }

}
