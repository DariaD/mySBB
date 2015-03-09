package com.servlet;

import com.jpa.entity.Station;
import com.jpa.servises.StationServices;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Дарья on 07.03.2015.
 */
public class AddStation extends HttpServlet {


    private ServletConfig config;

    public void init(ServletConfig config)
            throws ServletException {
        this.config = config;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
            try {
                StationServices service = new StationServices();
                String newStation = request.getParameter("newStation");

                for (Station station : service.getAll()) {
                    if (station.getName().equals(newStation)){
                        out.println("Station: " + newStation + " already exist.");
                        return;
                    }
                }
                Station station1 = new Station();
                station1.setName(newStation);
                Station station = service.add(station1);
                out.println("New station are added! ");
            } catch(Exception e){
                out.println(e);
            }
        }

}