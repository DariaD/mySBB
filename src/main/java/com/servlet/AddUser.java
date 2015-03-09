package com.servlet;

import com.jpa.entity.User;
import com.jpa.entity.UserList;
import com.jpa.servises.UserServices;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Created by Дарья on 08.03.2015.
 */
public class AddUser extends Dispatcher {
        public String getServletInfo(){
            return "Add user servlet";
        }
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            try {
                UserServices service = new UserServices();
                ServletContext ctx = getServletContext();
                if (request.getParameter("save") != null) {

                    String login = request.getParameter("login");
                    String password = request.getParameter("password");
                    String firstName = request.getParameter("firstName");
                    String secondName = request.getParameter("secondName");
                    Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateOfBirth"));
                    User newUser = new User();
                    newUser.setLogin(login);
                    newUser.setPassword(password);
                    newUser.setFirstName(firstName);
                    newUser.setSecondName(secondName);
                    newUser.setDateOfBirth(dateOfBirth);
                    ctx.setAttribute("user", newUser);
                    boolean res = UserList.addUser(newUser);
                    if (res) {
                        User user = service.add(newUser);
                        this.forward("/SuccessRegistration.jsp", request, response);
                    } else {
                        this.forward("/ErrorRegistration.jsp", request, response);
                    }
                } else if (request.getParameter("cancel") != null) {
                    this.forward("/Authentication.jsp", request, response);
                }
            }catch (Exception e) {
                this.forward("/ErrorRegistration.jsp", request, response);
            }
        }
}
