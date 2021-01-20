package uga.edu.bookmyticket.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Artist", schema="movie_booking")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="artist_ssn", nullable=false)
    String artist_ssn;

    @Column(name="artist_name", length=45, nullable=false)
    String artist_name;

    @Column(name="artist_role", length=45, nullable=false)
    String artist_role;

    public String getArtist_ssn() {
        return artist_ssn;
    }

    public void setArtist_ssn(String artist_ssn) {
        this.artist_ssn = artist_ssn;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getArtist_role() {
        return artist_role;
    }

    public void setArtist_role(String artist_role) {
        this.artist_role = artist_role;
    }

    public void printArtistEntity(Artist artist){
        System.out.println("Printing Artist Entity...");
        System.out.println("Artist SSN: "+artist.getArtist_ssn());
        System.out.println("Artist Name: "+artist.getArtist_name());
        System.out.println("Artist Role: "+artist.getArtist_role());

    }
}
