package uga.edu.bookmyticket.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movies", schema="movie_booking")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movie_id", nullable=false)
	int id;
	
	@Column(name="movie_name", length=45, nullable=false)
	String name;
	
	@Column(name="movie_rating", length=64, nullable=false)
	int rating;
	
	@Column(name="movie_release_date", length=45, nullable=false)
	String movie_release_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getMovie_release_date() {
		return movie_release_date;
	}

	public void setMovie_release_date(String movie_release_date) {
		this.movie_release_date = movie_release_date;
	}

	public void printMovieEntity(){
		System.out.println("Printing Movie Entity...");
		System.out.println("Movie ID: "+getId());
		System.out.println("Movie Name: "+getName());
		System.out.println("Movie Ratings: "+getRating());
		System.out.println("Movie Release Date: "+getMovie_release_date());

	}
}
