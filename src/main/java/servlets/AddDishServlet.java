/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Dish;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.Menu;

/**
 *
 * @author Lenovo
 */
@WebServlet("/add")
public class AddDishServlet extends HttpServlet {

    private Menu menu;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double weight = Double.valueOf(request.getParameter("weight"));
        double price = Double.valueOf(request.getParameter("price"));
        boolean isSale = false;
        if (request.getParameter("sale").equalsIgnoreCase("yes")) {
            isSale = true;
        }

        Boolean result = menu.addDish(name, weight, price, isSale);
        request.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(FindBySaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
