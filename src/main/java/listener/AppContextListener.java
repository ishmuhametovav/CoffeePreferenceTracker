package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import service.CoffeeService;
import service.TastingService;
import service.UserService;
import service.impl.InMemoryCoffeeServiceImpl;
import service.impl.InMemoryTastingServiceImpl;
import service.impl.InMemoryUserServiceImpl;

public class AppContextListener implements ServletContextListener
{

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        UserService userService = new InMemoryUserServiceImpl();
        CoffeeService coffeeService = new InMemoryCoffeeServiceImpl();
        TastingService tastingService = new InMemoryTastingServiceImpl();
        sce.getServletContext().setAttribute("userservice", userService);
        sce.getServletContext().setAttribute("coffeeservice", coffeeService);
        sce.getServletContext().setAttribute("tastingservice", tastingService);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {

    }
}
