package no.hvl.dat108;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "WebshopServlet", urlPatterns = {"webshop"}, loadOnStartup = 1) 
public class WebshopServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.getWriter().print("Hello, World!");
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("username") == null)
            response.sendRedirect("login" + "?requiresLogin");
        else {
            String username = (String)session.getAttribute("cart");
            Cart cart = (Cart)session.getAttribute("cart");
            response.setContentType("text/html; charset=ISO-8859-1");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = request.getParameter("Username");
        if(name == null) name = "Person";
        request.setAttribute("user", name);
        if (!(name.equals("Arne"))) request.getRequestDispatcher("loginFail.jsp").forward(request, response);
        else request.getRequestDispatcher("response.jsp").forward(request, response); 
    }
}