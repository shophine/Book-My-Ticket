package uga.edu.bookmyticket.view.bean;

public class MyTicketList {
    String ssn;
    String seatNumber;
    String showTime;
    int movieID;
    String movieName;
    int theaterID;
    String theater_name;
    String country;
    String state;

    String email;
    String phone;
    String userName;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public void setTheater_name(String theater_name) {
        this.theater_name = theater_name;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MyTicketList(String ssn, String seatNumber, String showTime, int movieID, String movieName, int theaterID, String theater_name, String country, String state, String email, String phone, String userName) {
        this.ssn = ssn;
        this.seatNumber = seatNumber;
        this.showTime = showTime;
        this.movieID = movieID;
        this.movieName = movieName;
        this.theaterID = theaterID;
        this.theater_name = theater_name;
        this.country = country;
        this.state = state;
        this.email = email;
        this.phone = phone;
        this.userName = userName;
    }

    public MyTicketList(String ssn) {
        this.ssn = ssn;
    }
}