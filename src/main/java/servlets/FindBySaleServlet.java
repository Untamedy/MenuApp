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
@WebServlet("/sale")
public class FindBySaleServlet extends HttpServlet {
    
    private Menu menu = new Menu();
     
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response){
        List<Dish> dishes = menu.findBySale();
        request.setAttribute("list", dishes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(FindBySaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FindBySaleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        
    }
    
}
