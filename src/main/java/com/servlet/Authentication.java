package com.servlet;

/**
 * Created by Дарья on 03.03.2015.
 */
import com.jpa.entity.Schedule;
import com.jpa.entity.Station;
import com.jpa.entity.Train;
import com.jpa.entity.User;
import com.jpa.servises.ScheduleService;
import com.jpa.servises.StationServices;
import com.jpa.servises.TrainServices;
import com.jpa.servises.UserServices;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

//public class Authentication extends Dispatcher{
public class Authentication extends HttpServlet {


    private ServletConfig config;

    public void init(ServletConfig config)
            throws ServletException {
        this.config = config;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String connectionURL = "jdbc:mysql://localhost:3308/sbbdatabase";
        Connection connection = null;
        ResultSet rs;
        String userName = new String("");
        String password = new String("");
        response.setContentType("text/html");

        try {
            boolean login = false;

            StationServices serviceStation = new StationServices();
            List<Station> stations = serviceStation.getAll();
            List stationList = new ArrayList();
            for (Station station : stations) {
                stationList.add(station.getName());
            }
            request.setAttribute("stationNames", stationList);

            TrainServices serviceTrain = new TrainServices();
            List<Train> trains = serviceTrain.getAll();
            List trainList = new ArrayList();
            for (Train train : trains) {
                trainList.add(train.getName());
            }
            request.setAttribute("trainNames", trainList);

            ScheduleService scheduleTrain = new ScheduleService();
            List<Schedule> schedules = scheduleTrain.getAll();
            List schedulesList = new ArrayList();
            for (Schedule schedule : schedules) {
                schedulesList.add(schedule.recordAsSearchResult());
            }
            request.setAttribute("schedulesList", schedulesList);

            UserServices userTrain = new UserServices();
            for (User user : userTrain.getAll()) {
                userName = user.getLogin();
                password = user.getPassword();
                boolean isAdmin = false;
                if(request.getParameter("user").equals("admin") || request.getParameter("user").equals("1")){
                    isAdmin = true;
                }
                if( isAdmin && password.equals(request.getParameter("pass")) && userName.equals(request.getParameter("user"))){
                    login = true;
                    forward("AdministratorPage.jsp", request, response);
                    break;
                } else if (!isAdmin && userName.equals(request.getParameter("user")) && password.equals(request.getParameter("pass"))){
                    login = true;

                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    session.setAttribute("userName", userName);
                    session.setAttribute("user", userName);

                    forward("Search.jsp", request, response);
                    break;
                }
            }
            if(!login){
                forward("ErrorUserLogin.jsp", request, response);
            }
        } catch (Exception e) {
            System.out.println("Exception is " + e);
        }
    }

    private void forward(String page, HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}