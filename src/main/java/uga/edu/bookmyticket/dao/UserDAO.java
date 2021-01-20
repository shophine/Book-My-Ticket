package uga.edu.bookmyticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uga.edu.bookmyticket.entity.Artist;
import uga.edu.bookmyticket.entity.Ticket;
import uga.edu.bookmyticket.entity.User;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Long>{

    @Query(value="SELECT * FROM User WHERE user_ssn = :ssnFromUser", nativeQuery = true)
    public User getUserByID(@Param("ssnFromUser") String ssnFromUser);

    @Query(value="select user_age from user WHERE user_ssn = :ssnFromUser", nativeQuery = true)
    public int getAge(@Param("ssnFromUser") String ssnFromUser);

    @Query(value="select user_age from user WHERE user_ssn = :ssnFromUser", nativeQuery = true)
    public int getAge(@Param("ssnFromUser") String ssnFromUser);

    @Query(value="SELECT user_name FROM user RIGHT JOIN ticket ON user.user_ssn = ticket.user_ssn",nativeQuery = true)
    public List<String> getPersonsFromTicket();

}
