package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Coffee;
import service.CoffeeService;

import java.io.IOException;

public class CoffeeController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/WEB-INF/views/coffees.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        CoffeeService service = (CoffeeService) getServletContext().getAttribute("coffeeservice");

        String name = request.getParameter("name");
        String origin = request.getParameter("origin");
        String variety = request.getParameter("variety");
        Coffee.Processing processing = getProcessing(request.getParameter("processing"));
        Coffee.Roast roastLevel = getRoastLevel(request.getParameter("roastlevel"));

        service.createCoffee(name, origin, variety, processing, roastLevel);
        response.sendRedirect(request.getContextPath() + "/profile");
    }
    private Coffee.Processing getProcessing(String processing) throws IllegalArgumentException
    {
        if(processing.equals("washed")) return Coffee.Processing.WASHED;
        else if(processing.equals("natural")) return Coffee.Processing.NATURAL;
        else if(processing.equals("honey")) return Coffee.Processing.HONEY;
        throw new IllegalArgumentException("No such processing!");
    }

    private Coffee.Roast getRoastLevel(String roastLevel) throws IllegalArgumentException
    {
        if(roastLevel.equals("light")) return Coffee.Roast.LIGHT;
        else if(roastLevel.equals("medium")) return Coffee.Roast.MEDIUM;
        else if(roastLevel.equals("dark")) return Coffee.Roast.LIGHT;
        throw new IllegalArgumentException("No such roast!");
    }
}
