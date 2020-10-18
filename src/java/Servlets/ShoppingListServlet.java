
package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joel Wood
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.isNew() || session.getAttribute("username")== null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        String logout = request.getParameter("logout");
        if (logout != null) {
            session.invalidate();
            session = request.getSession();
            response.sendRedirect("ShoppingList");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       HttpSession session = request.getSession();
       String username = request.getParameter("username");
       
       if(username == null || username.equals("")){
           session.setAttribute("registerMessage", "Please enter a username");
           getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
       }
       
       session.setAttribute("username", username);
       response.sendRedirect("ShoppingList");
    }

}
