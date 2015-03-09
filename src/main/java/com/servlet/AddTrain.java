package com.servlet;

import com.jpa.entity.Train;
import com.jpa.servises.TrainServices;

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
public class AddTrain  extends HttpServlet{
        private ServletConfig config;

        public void init(ServletConfig config)
                throws ServletException {
            this.config = config;
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            try {
                TrainServices service = new TrainServices();
                String newTrain = request.getParameter("trainname");

                for (Train train : service.getAll()) {
                    if (train.getName().equals(newTrain)){
                        out.println("Train: " + newTrain + " already exist.");
                        return;
                    }
                }
                Train train1 = new Train();
                train1.setName(newTrain);
                train1.setPlases(Integer.parseInt(request.getParameter("number")));
                Train station = service.add(train1);
                out.println("New train are added! ");
            } catch(Exception e){
                out.println(e);
            }
        }
}
