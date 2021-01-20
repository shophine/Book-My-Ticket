package uga.edu.bookmyticket.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uga.edu.bookmyticket.NowShowingDetailsForUser;
import uga.edu.bookmyticket.dao.LocationDAO;
import uga.edu.bookmyticket.dao.MovieDAO;
import uga.edu.bookmyticket.dao.NowShowingDAO;
import uga.edu.bookmyticket.dao.TheaterDAO;
import uga.edu.bookmyticket.entity.Location;
import uga.edu.bookmyticket.entity.Movie;
import uga.edu.bookmyticket.entity.NowShowing;
import uga.edu.bookmyticket.entity.Theater;
import uga.edu.bookmyticket.view.bean.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@Api(value = "bookmyticket")
@RestController
public class NowShowingController {
	
	@Autowired
	NowShowingDAO nowShowingDAO;

	@Autowired
	MovieDAO movieDAO;

	@Autowired
	TheaterDAO theaterDAO;

	@Autowired
	LocationDAO locationDAO;

	List<String> countryListFiltered;


	@CrossOrigin
	@GetMapping(value = "/getCountriesFromNowShowing", produces = "application/json")
	public List<CountryListForNowShowing> getCountriesFromNowShowing(){

		List<Integer> theaterIDList = new ArrayList<>();
		List<Integer> locationIDList = new ArrayList<>();
		List <Location> locationEntity = new ArrayList<>();
		List<String> countryList = new ArrayList<>();

		List<CountryListForNowShowing> countryListForNowShowingList = new ArrayList<>();

		try {
			theaterIDList = nowShowingDAO.getTheaterIDFromNowShowing();
			//System.out.println("Len"+ theaterIDList.size());
			for (Integer theaterID: theaterIDList) {
				locationIDList.add(theaterDAO.getTheaterLocationByID(theaterID));
			}

			for (Integer locationID: locationIDList) {
				locationEntity.add(locationDAO.getLocationDetails(locationID));
			}
			for (Location locationEntity1: locationEntity) {
				countryList.add(locationEntity1.getCountry_name());
			}
			countryListFiltered = countryList.stream()
					.distinct()
					.collect(Collectors.toList());
			for (String locationEntity1: countryListFiltered) {
				countryListForNowShowingList.add(new CountryListForNowShowing(locationEntity1));
			}
			//System.out.println("Length :"+countryListFiltered.size());
//			Set<String> hashSet = new LinkedHashSet(countryList);
//			countryListFiltered = new ArrayList(hashSet);


		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Something went wrong", e);
		}

		return countryListForNowShowingList;

	}


	@RequestMapping(method = RequestMethod.POST, value = "/getStateForSelectedCountry", produces="application/json")
	public List<StateListForNowShowing> getStateForSelectedCountry(@RequestBody CountryListForNowShowing userSelectedCountry) {
		List<String> statesOfACountryList = new ArrayList<>();
		List<StateListForNowShowing> stateListForNowShowingList = new ArrayList<>();
		System.out.println(userSelectedCountry.getCountry());
		try {
			statesOfACountryList = locationDAO.getStateFromCountry(userSelectedCountry.getCountry());
			for (String statesOfACountry: statesOfACountryList) {
				stateListForNowShowingList.add(new StateListForNowShowing(statesOfACountry));
			}

		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Something went wrong", e);
		}

		return stateListForNowShowingList;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getTheatersForSelectedState", produces="application/json")
	public List<TheaterListForNowShowing> getTheatersForSelectedState(@RequestBody StateListForNowShowing userSelectedState) {
		List<Integer> zipCodesInStateList = new ArrayList<>();
		List<Integer> theaterListFromZipCodeList = new ArrayList<>();
		List<TheaterListForNowShowing> theaterListForNowShowingList = new ArrayList<>();
		System.out.println(userSelectedState.getState());
		try {
			zipCodesInStateList = locationDAO.getZipCodeFromState(userSelectedState.getState());
			for (Integer zipCode: zipCodesInStateList) {
				theaterListFromZipCodeList = theaterDAO.getTheaterIDsFromZipCode(zipCode);
			}

			for (Integer theaterID: theaterListFromZipCodeList) {
				//System.out.println("TheaterID : "+theaterID);
				String theater_name = theaterDAO.getTheaterNameFromID(theaterID);
				theaterListForNowShowingList.add(new TheaterListForNowShowing(theater_name,theaterID));
			}



		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Something went wrong", e);
		}

		return theaterListForNowShowingList;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getMoviesFromTheater", produces="application/json")
	public List<NowShowingMoviesAtTheater> getMoviesFromTheater(@RequestBody UserSelectionForNowShowing userSelectionForNowShowing) {
//		System.out.println(userSelectionForNowShowing.getCountry());
//		System.out.println(userSelectionForNowShowing.getState());

				int i = userSelectionForNowShowing.getTheater_id();
		System.out.println(i);
//		System.out.println(userSelectionForNowShowing.getTheater_name());

		List<NowShowing> nowShowingAtTheaterList = new ArrayList<>();
		List<NowShowingMoviesAtTheater> nowShowingMoviesAtTheaterList = new ArrayList<>();

		try {
			nowShowingAtTheaterList = nowShowingDAO.getNowShowingDetailsByID(i);
			for(NowShowing nowShowingAtTheater: nowShowingAtTheaterList){
				int movieID = nowShowingAtTheater.getMovies_id();
				Movie movie = movieDAO.getMovieDetailsByID(movieID);
				String movieName = movie.getName();
				int movieRatings = movie.getRating();

				String showTime = nowShowingAtTheater.getShow_time();


				nowShowingMoviesAtTheaterList.add(
						new NowShowingMoviesAtTheater(
								movieName,
								movieRatings,
								showTime,
								userSelectionForNowShowing.getTheater_name(),
								userSelectionForNowShowing.getState(),
								userSelectionForNowShowing.getCountry()
						)
				);
			}


		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Something went wrong", e);
		}

		return nowShowingMoviesAtTheaterList;
	}






}
