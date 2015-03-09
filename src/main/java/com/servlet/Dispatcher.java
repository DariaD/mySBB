package com.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Created by Дарья on 08.03.2015.
 */
public class Dispatcher extends HttpServlet  {
    protected void forward(String address, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}