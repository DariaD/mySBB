package com.servlet;

import com.jpa.entity.Schedule;
import com.jpa.entity.Station;
import com.jpa.entity.Train;
import com.jpa.servises.StationServices;
import com.jpa.servises.ScheduleService;
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

/**
 * Created by Дарья on 07.03.2015.
 */
public class AddRoute extends HttpServlet {


    private ServletConfig config;

    public void init(ServletConfig config)
            throws ServletException {
        this.config = config;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String selectedTrain = request.getParameter("selectedTrain");
            String stationFrom = request.getParameter("selectedStationFrom");
            String dateFrom = request.getParameter("dateFrom");
            String timeFrom = request.getParameter("timeFrom");
            String stationTo = request.getParameter("selectedStationTo");
            String dateTo = request.getParameter("dateTo");
            String timeTo = request.getParameter("timeTo");

            TrainServices trainService = new TrainServices();
            StationServices stationServices = new StationServices();
            Schedule scheduleEntity = new Schedule();
            for (Train train : trainService.getAll()) {
                if(train.getName().equals(selectedTrain)){
                    scheduleEntity.setTrain(train);
                    scheduleEntity.setAvPlaces(train.getPlases());
                    train.addSchedule(scheduleEntity);
                }
            }
            boolean findFirst = false;
            boolean findSecond = false;
            for (Station station : stationServices.getAll()) {
                if(station.getName().equals(stationFrom)){
                    scheduleEntity.setStationFrom(station);
                    findFirst = true;
                    station.addScheduleFrom(scheduleEntity);
                } else if(station.getName().equals(stationTo)){
                    scheduleEntity.setStationTo(station);
                    station.addScheduleTo(scheduleEntity);
                    findSecond = true;
                } if(findFirst && findSecond){
                    break;
                }
            }
            /* Date input:
            * Date: 2015-03-16
            * Time: 04:04
            * Need: "2015-03-15 18:30:00"
            * */
            Date stopDateFrom = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateFrom + " " + timeFrom + ":00");
            scheduleEntity.setDateFrom(stopDateFrom);
            Date stopDateTo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateTo + " " + timeTo + ":00");
            scheduleEntity.setDateTo(stopDateTo);

            ScheduleService stopService = new ScheduleService();
            Schedule stopStationFrom = stopService.add(scheduleEntity);
            out.println("New train from "+ stationFrom + " to " + stationTo + " are added! ");

//        out.println("Selected Train: " + selectedTrain);
//        out.println("From: " + stationFrom);
//        out.println("Date: " + dateFrom);
//        out.println("Time: " + timeFrom);
//        out.println("To: " + stationTo);
//        out.println("Date: " + dateTo);
//        out.println("Time: " + timeTo);

        } catch (Exception e) {
            out.println(e);
        }

    }
}