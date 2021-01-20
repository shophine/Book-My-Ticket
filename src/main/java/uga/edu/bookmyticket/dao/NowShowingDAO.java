package uga.edu.bookmyticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uga.edu.bookmyticket.entity.Movie;
import uga.edu.bookmyticket.entity.NowShowing;

import java.util.List;

public interface NowShowingDAO extends JpaRepository<NowShowing,Integer>{

    @Query(value="SELECT * FROM Now_Showing WHERE theatre_id = :theaterIdFromUser", nativeQuery = true)
    public List<NowShowing> getNowShowingDetailsByID(@Param("theaterIdFromUser") int theaterIdFromUser);

    @Query(value="select theatre_id from now_showing", nativeQuery = true)
    public List<Integer> getTheaterIDFromNowShowing();


    @Query(value="select show_time from now_showing where theatre_id=:theaterID and movies_id=:movieID", nativeQuery = true)
    public String getShowTimingByTheaterIDAndMovieID(@Param("theaterID") int theaterID,@Param("movieID") int movieID);

    @Modifying
    @Query(value="INSERT INTO now_showing(movies_id,theatre_id,show_time) VALUES (:movieID,:theatre_id,:showTime)", nativeQuery = true)
    @Transactional
    public void insertRow(@Param("movieID") int movieID,@Param("theatre_id") int theatre_id,@Param("showTime") String showTime);



}
