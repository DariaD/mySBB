package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * Created by Дарья on 08.03.2015.
 */
public class Registration extends HttpServlet {
    public String getServletInfo(){
        return "Registration servlet";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
//        if (request.getParameter("login")!=null){
//            this.forward("/CheckUser", request, response);
//        } else if (request.getParameter("Registration")!=null) {
//            this.forward("/Registration.jsp", request, response);
//        }
        forward("/Registration.jsp", request, response);
    }

    private void forward(String page, HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}