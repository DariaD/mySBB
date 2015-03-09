package com.servlet;

import com.jpa.entity.*;
import com.jpa.servises.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Дарья on 08.03.2015.
 */
public class TicketBuy extends HttpServlet {


    private ServletConfig config;

    public void init(ServletConfig config)
            throws ServletException {
        this.config = config;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {

           /*Find train in schedule and check free places.*/
            String trainSelected = request.getParameter("train");
            int idSchedule = 0;
            if (trainSelected != null) {
               // out.println("value of selected radio: " + trainSelected);
                String[] split =  trainSelected.split(" ");
                idSchedule = Integer.parseInt(split[1]);
            } else {
                out.println("No radio button was selected. To buy a ticket you should to select one radio button was selected.");
                return;
            }
            ScheduleService scheduleServices = new ScheduleService();
            Schedule schedule = scheduleServices.get(idSchedule);
            int avplaces = schedule.getAvPlaces();
            if(!(avplaces > 0)){
                out.println("Sorry, you can't buy a ticket on this train. There ara no places any more. ");
                return;
            } else {
                schedule.setAvPlaces(avplaces - 1);
            }

            /*Check date. It should be more than 10 min before train*/
            Date currentDate = new Date();
            Date alloydDeplTime = add10Min(currentDate);
            out.println("Alloyd dep time: " + alloydDeplTime);
            out.println("Time of Train: " + schedule.getDateFrom());
            if(!alloydDeplTime.before(schedule.getDateFrom())){
                out.println("Sorry, you can't buy a ticket on this train. There is less then 10 min before this or it's already gone. ");
                return;
            } else {
                out.println("Time is ok! ");

            }

            /*Find and check user by Login*/
            HttpSession session = request.getSession();
            String userLogin = (String)session.getAttribute("userName") ;

            TicketServices ticketServices = new TicketServices();
            for(Ticket ticket : ticketServices.getAll()){
                if((ticket.getUser().getLogin()).equals(userLogin) && (ticket.getSchedule().getId() == idSchedule)){
                    out.println("It seems, you are already bougth the ticket on this train. You can't do it twice.");
                    return;
                }
            }

            /*Add ticket: information about user and schedule record.*/
            UserServices userServices = new UserServices();
            Ticket ticket = new Ticket();
            User userToAdd = new User();
            for (User user : userServices.getAll()) {
               // out.println("Have in Base: " + user.getLogin());

                if(user.getLogin().equals(userLogin)){
//                    out.println("**************************");
//                    out.println("User Login: " + userLogin);
//                    out.println("User in Base: " + user.getLogin());
//                    out.println(user.toString());
                    userToAdd = user;

                    break;
                }
            }
            if(userToAdd!=null) {
                ticket.setUser(userToAdd);

//                out.println("User added");
            } else {
                out.println("Ooooooooops... User is null...");
            }

            ticket.setSchedule(schedule);
            Ticket t = ticketServices.add(ticket);
            userToAdd.addTicket(ticket);
            schedule.addTicket(t);
            userServices.update(userToAdd);
            scheduleServices.update(schedule);
            out.println("Congratulations! You bought a ticket!");

        } catch (Exception e) {
            out.println(e);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            out.println("Message from Ticket Buy page DO POST");
        } catch (Exception e) {
            out.println(e);
        }

    }

    private void forward(String page, HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    private Date add10Min(Date date){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        String strDate = sdfDate.format(date);
        String[] dateAndTime = strDate.toString().split(" ");
        String stDate = dateAndTime[0];
        String stTime = dateAndTime[1];
        String[] timeParse = stTime.split(":");
        int min = Integer.parseInt(timeParse[1]);
        int hour = Integer.parseInt(timeParse[0]);
        min = min + 10;
        if(min > 60){
            hour = hour + 1;
            min = min - 60;
        }
        Date newDate = null;
        try {
            newDate = sdfDate.parse(String.format("%s %s:%s:00", stDate, hour, min));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}