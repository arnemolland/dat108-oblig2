package no.hvl.dat108;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TodoApp", urlPatterns = {"todoapp"}, loadOnStartup = 1) 
public class WebshopServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TodoList todoList = new TodoList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.getWriter().print("Hello, World!");
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("password") == null)
            response.sendRedirect("login" + "?requiresLogin");
        else {
            String password = (String)session.getAttribute("password");
            TodoList todoList = (TodoList)session.getAttribute("todoList");
            response.setContentType("text/html; charset=ISO-8859-1");

            request.setAttribute("name", password);
            request.setAttribute("todoList", todoList);
            request.getRequestDispatcher("todoApp.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
            HttpSession session = request.getSession(false);

            if(session == null || session.getAttribute("password") == null) 
                response.sendRedirect("login" + "?requiresLogin");
            else {
                 todoList = (TodoList) session.getAttribute("todoList");

                if(request.getParameter("bukse") != null) {
                    todoList.addItem(new TodoItem("Bukse"));
                }
                if(request.getParameter("genser") != null) {
                    todoList.addItem(new TodoItem("Genser"));
                }
                response.sendRedirect("todoapp");
            }
    }
}