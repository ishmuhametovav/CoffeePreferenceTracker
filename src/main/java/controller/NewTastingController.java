package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CoffeeService;

import java.io.IOException;

public class NewTastingController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        CoffeeService service = (CoffeeService) getServletContext().getAttribute("coffeeservice");
        request.setAttribute("coffees", service.getAllCoffees());
        getServletContext().getRequestDispatcher("/WEB-INF/views/new_tasting.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
