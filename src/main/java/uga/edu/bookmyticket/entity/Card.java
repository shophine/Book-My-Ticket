package uga.edu.bookmyticket.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Card", schema="movie_booking")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="card_no", nullable=false)
    String card_no;

    @Column(name="card_name", length=45, nullable=false)
    String name;

    @Column(name="card_expiry", length=45, nullable=false)
    String card_expiry;

    @Column(name="card_cvv", length=3, nullable=false)
    int card_cvv;

    @Column(name="user_ssn", nullable=false)
    String user_ssn;

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard_expiry() {
        return card_expiry;
    }

    public void setCard_expiry(String card_expiry) {
        this.card_expiry = card_expiry;
    }

    public int getCard_cvv() {
        return card_cvv;
    }

    public void setCard_cvv(int card_cvv) {
        this.card_cvv = card_cvv;
    }

    public String getUser_ssn() {
        return user_ssn;
    }

    public void setUser_ssn(String user_ssn) {
        this.user_ssn = user_ssn;
    }
}

