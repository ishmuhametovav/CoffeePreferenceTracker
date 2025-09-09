package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;
import java.io.PrintWriter;


public class RegistrationController extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserService userService = (UserService) getServletContext().getAttribute("userservice");

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String plainPassword = request.getParameter("password");

        userService.createUser(firstName, lastName, age, email, plainPassword);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write("We now know who you are!<br></br>");
        writer.close();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/WEB-INF/views/reg.html").forward(request, response);
    }
}
