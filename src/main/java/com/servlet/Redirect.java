package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;

/**
 * Created by Daria on 22.02.2015.
 */
public class Redirect extends HttpServlet {
    protected int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String msg = "Message from servlet!!!!!!";
        System.out.println(msg);
        req.setAttribute("msg", msg);

        PrintWriter out = res.getWriter();
        out.println("<h1>Hello Servlet</h1>");

        count++;
        req.setAttribute("current_count", count);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
}
