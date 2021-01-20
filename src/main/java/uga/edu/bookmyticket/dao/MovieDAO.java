package uga.edu.bookmyticket.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import uga.edu.bookmyticket.entity.Movie;

import javax.mail.Session;
import java.util.List;

public interface MovieDAO extends JpaRepository<Movie,Long>{

    @Query(value="SELECT * FROM Movies where movie_id = :idFromUser", nativeQuery = true)
    public Movie getMovieDetailsByID(@Param("idFromUser") int idFromUser);

    @Query(value="SELECT movie_name FROM Movies where movie_id = :idFromUser", nativeQuery = true)
    public String getMovieNameByID(@Param("idFromUser") int idFromUser);

    @Query(value="SELECT movie_id FROM Movies where movie_name = :movieName", nativeQuery = true)
    public List<Integer> getIDFromName(@Param("movieName") String movieName);



}
