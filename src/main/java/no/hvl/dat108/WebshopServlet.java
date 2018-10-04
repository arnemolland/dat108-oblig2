package no.hvl.dat108;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "WebshopServlet", urlPatterns = {"webshop"}, loadOnStartup = 1) 
public class WebshopServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public List<CartItem> cartItems = new ArrayList<CartItem>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.getWriter().print("Hello, World!");
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("username") == null)
            response.sendRedirect("login" + "?requiresLogin");
        else {
            String username = (String)session.getAttribute("username");
            Cart cart = (Cart)session.getAttribute("cart");
            response.setContentType("text/html; charset=ISO-8859-1");

            request.setAttribute("name", username);
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("webshop.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
            HttpSession session = request.getSession(false);

            if(session == null || session.getAttribute("username") == null) 
                response.sendRedirect("login" + "?requiresLogin");
            else {
                Cart cart = (Cart) session.getAttribute("cart");
                cartItems = cart.getItems();

                if(request.getParameter("bukse") != null) {
                    cart.addItem(new CartItem("Bukse", 699.0));
                }
                if(request.getParameter("genser") != null) {
                    cart.addItem(new CartItem("Genser", 399.0));
                }
                response.sendRedirect("webshop");
            }
    }
}