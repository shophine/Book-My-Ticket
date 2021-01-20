package uga.edu.bookmyticket.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uga.edu.bookmyticket.dao.*;
import uga.edu.bookmyticket.entity.*;
import uga.edu.bookmyticket.view.bean.BookTicketsFromUser;
import uga.edu.bookmyticket.view.bean.BookingConfirmation;
import uga.edu.bookmyticket.view.bean.MyTicketList;
import uga.edu.bookmyticket.view.bean.ViewMyTicket;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Api(value = "bookmyticket")
@RestController
public class UserController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    DummyDAO dummyDAO;

    @Autowired
    TicketDAO ticketDAO;

    @Autowired
    TheaterDAO theaterDAO;

    @Autowired
    NowShowingDAO nowShowingDAO;

    @Autowired
    MovieDAO movieDAO;

    @Autowired
    LocationDAO locationDAO;


    BookingConfirmation bookingConfirmationList = null;

    @RequestMapping(method = RequestMethod.POST, value = "/bookTickets", produces="application/json")
    public BookingConfirmation bookTickets(@RequestBody BookTicketsFromUser bookTicketsFromUser) {

        String userSSN = bookTicketsFromUser.getUserSSN();
        User userLoggedIn;

        String country;
        String state;
        int theater_id;
        String theater_name;
        String movieName;
        String showTime;

        List<Integer> movieIDs = new ArrayList<>();

        try {

            userLoggedIn = userDAO.getUserByID(userSSN);
            bookingConfirmationList = new BookingConfirmation(
                    userLoggedIn.getUser_ssn(),
                    userLoggedIn.getUser_name(),
                    userLoggedIn.getUser_email(),
                    userLoggedIn.getUser_phone(),
                    bookTicketsFromUser.getCountry(),
                    bookTicketsFromUser.getState(),
                    bookTicketsFromUser.getTheater_id(),
                    bookTicketsFromUser.getTheater_name(),
                    bookTicketsFromUser.getMovieName(),
                    bookTicketsFromUser.getShowTime()
                    );
           movieIDs = movieDAO.getIDFromName(bookTicketsFromUser.getMovieName());
            ticketDAO.insertRow(bookingConfirmationList.getSsn(),movieIDs.get(0),bookingConfirmationList.getTheater_id(),"C19");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Something went wrong", e);
        }

        return bookingConfirmationList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getMyTickets", produces="application/json")
    public List<MyTicketList> getMyTickets(@RequestBody ViewMyTicket viewMyTicket) {
        System.out.println("SSN : "+viewMyTicket.getSsn());
        List<Ticket> ticketsForUserList = new ArrayList<>();
        List<MyTicketList> response = new ArrayList<>();
        try {
            ticketsForUserList = dummyDAO.getTick(viewMyTicket.getSsn());
            for(Ticket ticket: ticketsForUserList){

                String ssn = ticket.getUser_ssn();
                String seatNumber = ticket.getSeat_number();
                int theaterID = ticket.getNow_showing_theater_id();
                int movieID = ticket.getNow_showing_movies_id();
//                System.out.println("TheatreID : "+theaterID);
//                System.out.println("MovieID : "+movieID);
                String showTime = nowShowingDAO.getShowTimingByTheaterIDAndMovieID(theaterID,movieID);
                if (showTime==null){
                    showTime = "11:50";
                    nowShowingDAO.insertRow(movieID,theaterID,"11:50");
                }


                User user = userDAO.getUserByID(ssn);

                String name = user.getUser_name();
                String email= user.getUser_email();
                String phone = user.getUser_phone();

                Theater theater = theaterDAO.getTheaterDetailsByID(theaterID);
                String theaterLocation = theater.getTheater_location();
                Location location = locationDAO.getLocationDetails(Integer.parseInt(theaterLocation));

                String country = location.getCountry_name();
                String state = location.getState();

                String theater_name = theaterDAO.getTheaterNameByID(theaterID);

                 String movieName = movieDAO.getMovieNameByID(movieID);


                MyTicketList myTicketList = new MyTicketList(
                        ssn,seatNumber,showTime,movieID,movieName,theaterID,theater_name,country,state,email,phone,name
                );
                response.add(myTicketList);

            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Something went wrong", e);
        }
        System.out.println("hey");
        System.out.println(response);

        return response;
    }





}
