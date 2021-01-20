package uga.edu.bookmyticket.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uga.edu.bookmyticket.entity.Artist;
import uga.edu.bookmyticket.entity.Movie;

public interface ArtistDAO extends JpaRepository<Artist,Long>{


}
