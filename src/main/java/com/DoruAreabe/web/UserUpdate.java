package com.DoruAreabe.web;

import com.DoruAreabe.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserUpdate", urlPatterns = {"/edit"})
public class UserUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(password.length()==0) UserService.editSelectedWithoutPassword(id,userName,email);
        else UserService.editSelectedWithPassword(id,userName,email,password);
        response.sendRedirect("http://localhost:8080");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        request.setAttribute("id",id);
        request.setAttribute("userName",userName);
        request.setAttribute("email",email);
        getServletContext().getRequestDispatcher("/WEB-INF/views/users/UserUpdate.jsp").forward(request,response);
    }
}
