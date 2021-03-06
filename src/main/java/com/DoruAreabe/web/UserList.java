package com.DoruAreabe.web;

import com.DoruAreabe.entity.User;
import com.DoruAreabe.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserList", urlPatterns = {""})
public class UserList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = UserService.listOfAll();
        request.setAttribute("userList",userList);
        getServletContext().getRequestDispatcher("/WEB-INF/views/users/UserCRUD.jsp").forward(request,response);
    }
}
