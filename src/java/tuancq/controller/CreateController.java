package tuancq.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tuancq.dao.FoodDAO;
import tuancq.dto.FoodErrDTO;

/**
 *
 * @author ADmin
 */
@WebServlet(urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String SUCCESS = "home.jsp";
    private static final String ERROR = "create.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String price = request.getParameter("price");
            String cookingTime = request.getParameter("cookingTime");
            Date date = new Date();
            FoodErrDTO error = new FoodErrDTO();
            boolean check = false;
            if (id != null && (id.length() < 4 || id.length() > 10)) {
                error.setIdErr("Foodid must be from 4 to 10 character");
                check = true;

            }
            if (name != null && (name.length() < 4 || name.length() > 10)) {
                error.setNameErr("FoodName must be from 4 to 10 character");
                check = true;
            }
            if (description != null && (description.length() < 4 || description.length() > 10)) {
                error.setDescriptionErr("Description must be from 4 to 10 character");
                check = true;
            }
            boolean numberCookingTime = cookingTime.chars().allMatch(Character::isDigit);
            boolean numberprice = price.chars().allMatch(Character::isDigit);
            if (numberprice == false) {
                check = true;
                error.setPriceErr("Price is not the number!!!");
            }
            if (numberCookingTime == false) {
                check = true;
                error.setCookingTimeErr("CookingTime is not the number!!!");
            }
            if (check) {
                request.setAttribute("ERROR", error);
            } else {
                FoodDAO dao = new FoodDAO();
                float p = Float.parseFloat(price);
                int cook = Integer.parseInt(cookingTime);
                boolean result = dao.createFood(id, name, description, p, cook, "True", date);
                if(result){
                    url =SUCCESS;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
