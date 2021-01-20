package uga.edu.bookmyticket.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Theater", schema="movie_booking")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="theater_id", nullable=false)
    int theater_id;

    @Column(name="theater_name", length=45, nullable=false)
    String theater_name;

    @Column(name="theater_location", length=45, nullable=false)
    String theater_location;

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

    public String getTheater_location() {
        return theater_location;
    }

    public void setTheater_location(String theater_location) {
        this.theater_location = theater_location;
    }

    public void printTheaterEntity(){
        System.out.println("Printing Theater Entity...");
        System.out.println("Theater ID: "+getTheater_id());
        System.out.println("Theater Name: "+getTheater_name());
        System.out.println("Theater Location: "+getTheater_location());


    }
}
