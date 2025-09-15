package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import model.User;

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

        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || plainPassword.isEmpty())
        {
            request.setAttribute("error", "All information has to be filled!");
            request.getRequestDispatcher("/WEB-INF/views/reg.jsp").forward(request, response);
            return;
        }
        try
        {
            User user = userService.createUser(firstName, lastName, age, email, plainPassword);
            request.getSession().setAttribute("userid", user.getId());

        }catch (IOException ex)
        {
            request.setAttribute("error", "Age must be positive!");
            request.getRequestDispatcher("/WEB-INF/views/reg.jsp").forward(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/profile");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/WEB-INF/views/reg.jsp").forward(request, response);
    }
}
