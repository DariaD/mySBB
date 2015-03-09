package com.servlet;

import com.jpa.entity.Schedule;
import com.jpa.entity.Station;
import com.jpa.entity.Ticket;
import com.jpa.entity.User;
import com.jpa.servises.ScheduleService;
import com.jpa.servises.StationServices;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Дарья on 09.03.2015.
 */
public class ShowStationSchedule extends HttpServlet {

    private ServletConfig config;

    public void init(ServletConfig config)
            throws ServletException {
        this.config = config;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String selectedStation = request.getParameter("selectedStation");

            StationServices stationService = new StationServices();
            List<String> trainsTo = new ArrayList<String>();
            List<String> trainsFrom = new ArrayList<String>();
            Station stationCurr = null;
            for (Station station : stationService.getAll()) {
                if (station.getName().equals(selectedStation)) {
                    stationCurr = station;
                    break;
                }
            }
            if (stationCurr != null) {
                Set<Schedule> scheduleFrom = stationCurr.getScheduleFrom();
                out.println("Arrive");
                out.println("</br>");
                for (Schedule s : scheduleFrom) {
                    out.println(s.recordAsSearchResult());
                    out.println("</br>");
                }
                out.println("Departure");
                out.println("</br>");
                Set<Schedule> scheduleTo = stationCurr.getScheduleTo();
                for (Schedule s : scheduleTo) {
                    out.println(s.recordAsSearchResult());
                    out.println("</br>");
                }

            }

        } catch (Exception e) {
            out.println(e);
        }

    }
}