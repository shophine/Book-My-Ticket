package uga.edu.bookmyticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uga.edu.bookmyticket.entity.Artist;
import uga.edu.bookmyticket.entity.Ticket;
import uga.edu.bookmyticket.entity.User;

import java.util.List;

public interface TicketDAO extends JpaRepository<Ticket,Long>{

    @Query(value="select * from ticket where user_ssn= :ssnFromUser", nativeQuery = true)
    public List<Ticket> getTicketsByID(@Param("ssnFromUser") String ssnFromUser);

    @Query(value="select user_ssn from ticket",nativeQuery = true)
    public List<String> getSSNFromTicket();

    @Query(value="select * from ticket where user_ssn = :ssn",nativeQuery = true)
    public List<Ticket> getTicket(@Param("ssn") String ssn);

    @Modifying
    @Query(value="insert into ticket(user_ssn,now_showing_movies_id,now_showing_theater_id,seat_number) values (:userSSN,:movieID,:theatre_id,:seatNumber)", nativeQuery = true)
    @Transactional
    public void insertRow(@Param("userSSN") String userSSN,@Param("movieID") int movieID,@Param("theatre_id") int theatre_id,@Param("seatNumber") String seatNumber);

    @Query(value="select ticket.* from ticket join user on ticket.user_ssn = user.user_ssn where user.user_age<50 limit 500;",nativeQuery = true)
    public List<Ticket> getPersonsFromTicket();

    @Query(value="select ticket.* from ticket join user on ticket.user_ssn = user.user_ssn where user.user_age<50 limit 500;",nativeQuery = true)
    public List<Ticket> getTicketsByPersonsAge();
}
