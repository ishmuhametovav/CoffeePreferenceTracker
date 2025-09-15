package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AuthFilter implements Filter
{
    Set<String> publicPaths = new HashSet<>();
    @Override
    public void init(FilterConfig config)
    {
        publicPaths.add("/reg");
        publicPaths.add("/auth");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        String path = getRequestPath((HttpServletRequest) request);
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        boolean isPublic = isPublic(path);
        boolean loggedIn = session != null && session.getAttribute("userid") != null;

        if(isPublic || loggedIn)
        {
            chain.doFilter(request, response);
            return;
        }

        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(((HttpServletRequest) request).getContextPath() + "/auth");
    }
    @Override
    public void destroy()
    {

    }
    private String getRequestPath(HttpServletRequest request)
    {
        String uri = request.getRequestURI();
        String context = request.getContextPath();
        return uri.substring(context.length());
    }
    private boolean isPublic(String path)
    {
        if(path == null || path.equals("/") || path.isEmpty()) return true;
        if(publicPaths.contains(path)) return true;
        for (String p : publicPaths) {
            if (p.endsWith("/") && path.startsWith(p)) return true;
        }
        return false;
    }
}
