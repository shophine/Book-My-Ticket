package uga.edu.bookmyticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uga.edu.bookmyticket.entity.Artist;
import uga.edu.bookmyticket.entity.Location;
import uga.edu.bookmyticket.entity.NowShowing;
import uga.edu.bookmyticket.entity.Theater;

import java.util.List;

public interface LocationDAO extends JpaRepository<Location,Long>{

    @Query(value="SELECT * FROM Location WHERE zipcode = :locationIdFromUser", nativeQuery = true)
    public Location getLocationDetails(@Param("locationIdFromUser") int locationIdFromUser);

    @Query(value="SELECT state FROM location WHERE country_name = :countryFromUser", nativeQuery = true)
    public List<String> getStateFromCountry(@Param("countryFromUser") String countryFromUser);

    @Query(value="SELECT zipcode FROM location WHERE state = :stateFromUser", nativeQuery = true)
    public List<Integer> getZipCodeFromState(@Param("stateFromUser") String stateFromUser);


}
