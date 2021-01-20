package uga.edu.bookmyticket.controller;

import io.swagger.annotations.Api;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import uga.edu.bookmyticket.dao.MovieDAO;
import uga.edu.bookmyticket.dao.TicketDAO;
import uga.edu.bookmyticket.dao.UserDAO;
import uga.edu.bookmyticket.entity.Movie;
import uga.edu.bookmyticket.entity.Ticket;
import uga.edu.bookmyticket.view.bean.AnalyticsOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Api(value = "bookmyticket")
@RestController
public class TicketController {
	
	@Autowired
	TicketDAO ticketDAO;

	@Autowired
	UserDAO userDAO;
	
	@CrossOrigin
	@GetMapping(value = "/showAnalytics", produces = "application/json")
	public List<AnalyticsOutput> performAnalysis(){
		List<Movie> movies = new ArrayList<>();
		List<String> ssnList = new ArrayList<>();
		List<Integer> ageList = new ArrayList<>();
		List<AnalyticsOutput> array = new ArrayList<>();
		try {
			ssnList = ticketDAO.getSSNFromTicket();
			for (String ssn: ssnList) {
				ageList.add(userDAO.getAge(ssn));
			}
			Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

			for (int i : ageList) {
				Integer j = hm.get(i);
				hm.put(i, (j == null) ? 1 : j + 1);
			}

			// displaying the occurrence of elements in the arraylist
			for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
				System.out.println("Element " + val.getKey() + " "
						+ "occurs"
						+ ": " + val.getValue() + " times");
				AnalyticsOutput analyticsOutput = new AnalyticsOutput(val.getKey(),val.getValue());
//				json.put("age", val.getKey());
//				json.put("occurence", val.getValue());
				array.add(analyticsOutput);
			}

			//JSONObject analyticsResult = new JSONObject(hm);
			//System.out.println(array);



		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Something went wrong", e);
		}
	return array;
		
	}



}
