package com.servlet;

import com.jpa.entity.*;
import com.jpa.servises.ScheduleService;
import com.jpa.servises.StationServices;
import com.jpa.servises.TrainServices;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * Created by Дарья on 09.03.2015.
 */
public class PassengerViewer extends HttpServlet {

    private ServletConfig config;

    public void init(ServletConfig config)
            throws ServletException {
        this.config = config;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String selectedScheduleRecord = request.getParameter("selectedScheduleRecord");
            String[] split =  selectedScheduleRecord.split(" ");
            int idSchedule = Integer.parseInt(split[1]);

            ScheduleService scheduleService = new ScheduleService();
            Schedule schedule = scheduleService.get(idSchedule);
            Set<Ticket> tickets = schedule.getTickets();
            for(Ticket ticket : tickets){
                User user = ticket.getUser();
                out.println(String.format("Passenger: Name - %s %s Date of Birth - %s Login name: %s",
                        user.getFirstName(),user.getSecondName(), user.getDateOfBirth(), user.getLogin()
                        ));
            }
            out.println( String.format("Free places: %s", schedule.getAvPlaces()));

        } catch (Exception e) {
            out.println(e);
        }

    }
}