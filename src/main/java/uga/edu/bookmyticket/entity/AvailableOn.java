package uga.edu.bookmyticket.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="Available_On", schema="movie_booking")
public class AvailableOn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id", nullable=false)
    int movie_id;

    @Column(name="ott_id", nullable=false)
    int ott_id;

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getOtt_id() {
        return ott_id;
    }

    public void setOtt_id(int ott_id) {
        this.ott_id = ott_id;
    }
}

