package uga.edu.bookmyticket.view.bean;

public class TheaterListForNowShowing {
    String theater_name;
    int theater_id;

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public TheaterListForNowShowing(String theater_name, int theater_id) {
        this.theater_name = theater_name;
        this.theater_id = theater_id;
    }

    public TheaterListForNowShowing() {
    }
}
