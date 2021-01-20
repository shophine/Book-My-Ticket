package uga.edu.bookmyticket.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Ticket", schema="movie_booking")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_ssn", nullable=false)
    String user_ssn;

    @Column(name="now_showing_movies_id", nullable=false)
    int now_showing_movies_id;

    @Column(name="now_showing_theater_id", nullable=false)
    int now_showing_theater_id;

    @Column(name="seat_number", length=45, nullable=false)
    String seat_number;

    public String getUser_ssn() {
        return user_ssn;
    }

    public void setUser_ssn(String user_ssn) {
        this.user_ssn = user_ssn;
    }

    public int getNow_showing_movies_id() {
        return now_showing_movies_id;
    }

    public void setNow_showing_movies_id(int now_showing_movies_id) {
        this.now_showing_movies_id = now_showing_movies_id;
    }

    public int getNow_showing_theater_id() {
        return now_showing_theater_id;
    }

    public void setNow_showing_theater_id(int now_showing_theater_id) {
        this.now_showing_theater_id = now_showing_theater_id;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }
}
