package uga.edu.bookmyticket.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


@Entity
@Table(name="Now_Showing", schema="movie_booking")
public class NowShowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movies_id", nullable=false)
    int movies_id;

    @Column(name="theatre_id", nullable=false)
    int theater_id;

    @Column(name="show_time", length=45, nullable=false)
    String show_time;

    public int getMovies_id() {
        return movies_id;
    }

    public void setMovies_id(int movies_id) {
        this.movies_id = movies_id;
    }

    public int getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(int theater_id) {
        this.theater_id = theater_id;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public void printNowShowingEntity(){
        System.out.println("Printing NowShowing Entity...");
        System.out.println("Movie ID: "+getMovies_id());
        System.out.println("Theater ID: "+getTheater_id());
        System.out.println("Show Timings: "+getShow_time());


    }
}

