package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tasting;
import service.TastingService;

import java.io.IOException;
import java.util.List;

public class DeleteTastingController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        TastingService service = (TastingService) getServletContext().getAttribute("tastingservice");
        int userId = (int)request.getSession().getAttribute("userid");
        List<Tasting> tastings = service.findTastingByUserId(userId);
        request.setAttribute("tastings", tastings);
        getServletContext().getRequestDispatcher("/WEB-INF/views/delete_tasting.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        TastingService service = (TastingService) getServletContext().getAttribute("tastingservice");
        int tastingId = Integer.valueOf(request.getParameter("tastingid"));
        service.deleteTasting(tastingId);
        response.sendRedirect(getServletContext().getContextPath() + "/profile");
    }
}
