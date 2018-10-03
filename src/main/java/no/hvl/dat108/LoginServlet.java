package no.hvl.dat108;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"login"}, loadOnStartup = 1) 
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        boolean requiresLoginRedirect = request
        .getParameter("requiresLogin") != null;
        boolean invalidUsernameRedirect = request
        .getParameter("invalidUsername") != null;

        response.setContentType("text/hmtl; charset=ISO-8859-1");

        request.setAttribute("requiresLoginRedirect", requiresLoginRedirect);
        request.setAttribute("invalidUsernameRedirect", invalidUsernameRedirect);
        request.getRequestDispatcher("loginError.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");

        if(username == null || !Validator.isValidUsername(username))
            response.sendRedirect("login" + "?invalidUsername");
        else {
            HttpSession session = request.getSession(false);
            if(session != null)
                session.invalidate();
            session = request.getSession(true);
            session.setMaxInactiveInterval(10);
            
            session.setAttribute("username", username);
            session.setAttribute("cart", new Cart());

            response.sendRedirect("webshop");
        }
    }
}