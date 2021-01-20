package uga.edu.bookmyticket.entity;

import javax.persistence.*;

@Entity
@Table(name="Location", schema="movie_booking")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="zipcode", nullable=false)
    int zipcode;

    @Column(name="state", length=45, nullable=false)
    String state;

    @Column(name="country_name", length=45, nullable=false)
    String country_name;

    @Column(name="country_code", nullable=false)
    int country_code;

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public int getCountry_code() {
        return country_code;
    }

    public void setCountry_code(int country_code) {
        this.country_code = country_code;
    }
}


