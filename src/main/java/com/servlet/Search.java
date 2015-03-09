package com.servlet;

import com.jpa.entity.Schedule;
import com.jpa.servises.ScheduleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Дарья on 04.03.2015.
 */
public class Search extends HttpServlet {
    private ServletConfig config;
    public void init(ServletConfig config)
            throws ServletException {
        this.config=config;
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        PrintWriter out = response.getWriter();
        String stationFrom = request.getParameter("selectedStationFrom");
        String stationTo = request.getParameter("selectedStationTo");
        String dateFrom = request.getParameter("date");
        try {
            ScheduleService scheduleService = new ScheduleService();
            List<String> suitableTrainList = new ArrayList();
            boolean findSomething = false;
            for (Schedule record : scheduleService.getAll()) {

           /* Date input:
            * Date need: "2015-03-16"
            * Date have: "2015-03-15 18:30:00"
            *             012345678910
            * */
//                String recordDateFrom = record.getDateFrom().toString().substring(0,10);
                String recordDateFrom = record.getDateFrom().toString();
                String stationDBFrom= record.getStationFrom().getName();
                String stationDBTo= record.getStationTo().getName();
                if(stationFrom.equals(stationDBFrom)
                        && stationTo.equals(stationDBTo)
                        //&& dateFrom.equals(recordDateFrom)
                        && recordDateFrom.contains(dateFrom)
                        ){
                    findSomething = true;
                    suitableTrainList.add(record.recordAsSearchResult());
                }
            }
            if(findSomething){
                request.setAttribute("suitableTrainList", suitableTrainList);
                forward("SearchResult.jsp", request, response);
            }else {

                out.print("Sorry, we can't find suitable train for you. Please choose another destination or date.");
                out.print("Check your request:");
                out.print("From: " + stationFrom);
                out.print("To:" + stationTo);
                out.print("Date:" + dateFrom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void forward(String page, HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}