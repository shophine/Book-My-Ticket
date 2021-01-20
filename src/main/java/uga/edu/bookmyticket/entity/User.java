package uga.edu.bookmyticket.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="User", schema="movie_booking")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_ssn", nullable=false)
    String user_ssn;

    @Column(name="user_name", length=45, nullable=false)
    String user_name;

    @Column(name="user_email", length=64, nullable=false)
    String user_email;

    @Column(name="user_phone", length=10, nullable=false)
    String user_phone;

    public String getUser_ssn() {
        return user_ssn;
    }

    public void setUser_ssn(String user_ssn) {
        this.user_ssn = user_ssn;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}





