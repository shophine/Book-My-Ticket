package uga.edu.bookmyticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uga.edu.bookmyticket.entity.Location;
import uga.edu.bookmyticket.entity.Ticket;

import java.util.List;

public interface DummyDAO extends JpaRepository<Ticket,Long>{

    @Query(value="SELECT * FROM ticket WHERE user_ssn = :ssn", nativeQuery = true)
    public List<Ticket> getTick(@Param("ssn") String ssn);

}
