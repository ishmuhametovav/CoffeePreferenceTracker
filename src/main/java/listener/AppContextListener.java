package listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import service.UserService;
import service.impl.InMemoryUserServiceImpl;

public class AppContextListener implements ServletContextListener
{

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        UserService userService = new InMemoryUserServiceImpl();
        sce.getServletContext().setAttribute("userservice", userService);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {

    }
}
