package uga.edu.bookmyticket.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="worked_in", schema="movie_booking")
public class WorkedIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="artist_ssn", nullable=false)
    String artist_ssn;

    @Column(name="movies_id", nullable=false)
    int movies_id;

    public String getArtist_ssn() {
        return artist_ssn;
    }

    public void setArtist_ssn(String artist_ssn) {
        this.artist_ssn = artist_ssn;
    }

    public int getMovies_id() {
        return movies_id;
    }

    public void setMovies_id(int movies_id) {
        this.movies_id = movies_id;
    }
}
