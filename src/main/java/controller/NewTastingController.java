package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tasting;
import service.CoffeeService;
import service.TastingService;

import java.io.IOException;
import java.security.InvalidParameterException;

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
        TastingService service = (TastingService)getServletContext().getAttribute("tastingservice");

        int coffeeId = Integer.valueOf(request.getParameter("coffeeid"));
        String review = request.getParameter("review");
        int userId = (int)request.getSession().getAttribute("userid");
        Tasting.GRADE grade = getGrade(request.getParameter("grade"));

        service.createTasting(userId, coffeeId, grade, review);
        response.sendRedirect(getServletContext().getContextPath() + "/profile");
    }
    private Tasting.GRADE getGrade(String grade) throws InvalidParameterException
    {
        if(grade.equals("d")) return Tasting.GRADE.D;
        if(grade.equals("c")) return Tasting.GRADE.C;
        if(grade.equals("b")) return Tasting.GRADE.B;
        if(grade.equals("a")) return Tasting.GRADE.A;
        if(grade.equals("s")) return Tasting.GRADE.S;
        throw  new InvalidParameterException("No such grade!");
    }
}
