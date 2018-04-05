package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form //DONE
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        if (DaoFactory.getUsersDao().findByUsername(username) == null){
            User newUser = new User(username, email, password);
            DaoFactory.getUsersDao().insert(newUser);
        } else {
            System.out.println("That user already exists");
        }

        // TODO: if a user was successfully created, send them to their profile
        response.sendRedirect("/profile");
    }
}
