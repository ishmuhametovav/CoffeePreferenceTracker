package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import service.CoffeeService;
import service.UserService;
import service.impl.InMemoryCoffeeServiceImpl;
import service.impl.InMemoryUserServiceImpl;

public class AppContextListener implements ServletContextListener
{

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        UserService userService = new InMemoryUserServiceImpl();
        CoffeeService coffeeService = new InMemoryCoffeeServiceImpl();
        sce.getServletContext().setAttribute("userservice", userService);
        sce.getServletContext().setAttribute("coffeeservice", coffeeService);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {

    }
}
