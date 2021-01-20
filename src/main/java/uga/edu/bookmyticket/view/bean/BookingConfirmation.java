package uga.edu.bookmyticket.view.bean;

public class BookingConfirmation {
    String ssn;
    String name;
    String email;
    String phone;
    String country;
    String state;
    int theater_id;
    String theater_name;
    String movieName;
    String showTime;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public BookingConfirmation(String ssn, String name, String email, String phone, String country, String state, int theater_id, String theater_name, String movieName, String showTime) {
        this.ssn = ssn;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.state = state;
        this.theater_id = theater_id;
        this.theater_name = theater_name;
        this.movieName = movieName;
        this.showTime = showTime;
    }

    public BookingConfirmation(String ssn) {
        this.ssn = ssn;
    }
}
