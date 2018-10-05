package no.hvl.dat108;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"login", "/"}, loadOnStartup = 1, initParams = {@WebInitParam(name="pwd", value="dat108")}) 
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        boolean requiresLoginRedirect = request
        .getParameter("requiresLogin") != null;
        boolean invalidPasswordRedirect = request
        .getParameter("invalidPassword") != null;

        response.setContentType("text/hmtl; charset=ISO-8859-1");

        request.setAttribute("requiresLoginRedirect", requiresLoginRedirect);
        request.setAttribute("invalidPasswordRedirect", invalidPasswordRedirect);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        
        String password = request.getParameter("passwords");

        if(password == null || !password.equals(getInitParameter("pwd")))
            response.sendRedirect("login" + "?invalidPassword");
        else {
            HttpSession session = request.getSession(false);
            if(session != null)
                session.invalidate();
            session = request.getSession(true);
            session.setMaxInactiveInterval(10);
            
            session.setAttribute("password", password);
            session.setAttribute("todoList", new TodoList());

            response.sendRedirect("todoapp");
        }
    }
}