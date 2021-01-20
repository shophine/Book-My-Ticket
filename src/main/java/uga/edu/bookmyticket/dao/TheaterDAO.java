package uga.edu.bookmyticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uga.edu.bookmyticket.entity.Artist;
import uga.edu.bookmyticket.entity.Theater;

import java.util.List;

public interface TheaterDAO extends JpaRepository<Theater,Long>{


    @Query(value="SELECT theater_name FROM Theater WHERE theater_id = :idFromUser", nativeQuery = true)
    public String getTheaterNameByID(@Param("idFromUser") int idFromUser);

    @Query(value="SELECT * FROM Theater WHERE theater_id = :idFromUser", nativeQuery = true)
    public Theater getTheaterDetailsByID(@Param("idFromUser") int idFromUser);


    @Query(value="select theater_location from theater where theater_id = :idFromUser", nativeQuery = true)
    public int getTheaterLocationByID(@Param("idFromUser") int idFromUser);

    @Query(value="select theater_id from theater where theater_location = :zipCodeFromUser", nativeQuery = true)
    public List<Integer> getTheaterIDsFromZipCode(@Param("zipCodeFromUser") int zipCodeFromUser);

    @Query(value="select theater_name from theater where theater_id= :theaterIDFromUser", nativeQuery = true)
    public String getTheaterNameFromID(@Param("theaterIDFromUser") int theaterIDFromUser);

}
