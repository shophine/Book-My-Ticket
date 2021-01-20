package uga.edu.bookmyticket.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="OTT", schema="movie_booking")
public class Ott {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ott_id", nullable=false)
    int id;

    @Column(name="ott_platform", length=45, nullable=false)
    String ott_platform;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOtt_platform() {
        return ott_platform;
    }

    public void setOtt_platform(String ott_platform) {
        this.ott_platform = ott_platform;
    }

    public void printOTTEntity(){
        System.out.println("Printing OTT Entity...");
        System.out.println("OTT ID: "+getId());
        System.out.println("OTT Platform: "+getOtt_platform());


    }
}


