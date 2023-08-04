/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dbhandle.ProductDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
public class CartProduct extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ProductDao dao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listProduct", loginController.addCart);
        // Forward the request to the JSP page
        request.getRequestDispatcher("productCart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cartProductValue = request.getParameter("showCart");
        if (cartProductValue != null && cartProductValue.equals("true")) {
            // Set the listProduct as a request attribute
            System.out.println("showCart");
            // show list product
            request.setAttribute("listProduct", loginController.addCart);
            // Forward the request to the JSP page
            request.getRequestDispatcher("productCart.jsp").forward(request, response);
        }

        String deleteCartProductValue = request.getParameter("deleteCart");
        if (deleteCartProductValue != null ) {
            // Set the listProduct as a request attribute
            System.out.println("deleteCart");
            // show list product
            for (int i = 0; i <= loginController.addCart.size(); i++) {
                loginController.addCart.remove(i);
                System.out.println("Remove");
            }
        }
        if (!loginController.addCart.isEmpty()) {
            // show list product
            // Set the listProduct as a request attribute
            request.setAttribute("listProduct", loginController.addCart);
            // Forward the request to the JSP page
            request.getRequestDispatcher("productCart.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("cartNull.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
