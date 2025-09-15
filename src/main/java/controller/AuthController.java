package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PasswordUtil;
import model.User;
import service.UserService;

import java.io.IOException;
import java.security.InvalidParameterException;

public class AuthController extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UserService service = (UserService)getServletContext().getAttribute("userservice");
        String email = request.getParameter("email");
        String plainPassword = request.getParameter("password");

        try
        {
            User user = service.findUserByEmail(email);

            if(PasswordUtil.verify(plainPassword, user.getHashPassword()))
            {
                request.getSession().setAttribute("userid", user.getId());
                response.sendRedirect(request.getContextPath() + "/profile");
                return;

            }
        }
        catch(InvalidParameterException ex)
        {
            request.setAttribute("error", "Incorrect email or password!");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
