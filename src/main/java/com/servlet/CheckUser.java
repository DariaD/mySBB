package com.servlet;

import com.jpa.entity.User;
import com.jpa.entity.UserList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Дарья on 08.03.2015.
 */
public class CheckUser extends Dispatcher {
    public String getServletInfo(){
        return "Registration servlet";
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = UserList.findUser(request.getParameter("user"));
        if (user == null){
            this.forward("/Registration.html", request, response);
        } else {
            if(!user.getPassword().equals(request.getParameter("password"))){
                this.forward("/Registration.html", request, response);
            } else {
                this.forward("/SuccessUserLogin.jsp", request, response);
            }
        }
    }

}