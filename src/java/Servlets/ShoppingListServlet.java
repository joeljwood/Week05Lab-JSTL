package Servlets;

import java.io.IOException;
import java.util.ArrayList;
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

    ArrayList<String> shoppingItems = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (session.isNew() || session.getAttribute("username") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        if (action != null && action.equals("logout")) {
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

        String action = request.getParameter("action");
        String username = request.getParameter("username");

        switch (action) {
            case "register":
                if (username == null || username.equals("")) {
                    session.setAttribute("registerMessage", "Please enter a username");
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                }
                session.setAttribute("username", username);
                response.sendRedirect("ShoppingList");
                break;
            case "add":
                String listItem = request.getParameter("listInput");
                shoppingItems.add(listItem);
                session.setAttribute("shopingItems", shoppingItems);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                break;
            case "delete":
                String deleteItem = request.getParameter("item");

                int delete = shoppingItems.indexOf(deleteItem);
                if (delete > -1) {

                    shoppingItems.remove(delete);
                    session.setAttribute("shoppingItems", shoppingItems);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                }
                break;
            default:
                break;
        }

    }

}
