package controller;

import dbhandle.ProductDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

public class UserView extends HttpServlet {

    private static final long serialVersionUID = 1L;
    ProductDao dao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // show list product
        List<Product> listProduct;
        try {
            listProduct = dao.getAllProduct();

            // Set the listProduct as a request attribute
            request.setAttribute("listProduct", listProduct);

            // Forward the request to the JSP page
            request.getRequestDispatcher("productUser.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> listProduct;

        // addProduct method
        String addProductValue = request.getParameter("addCartProduct");
        if (addProductValue != null) {
            try {
                String id = request.getParameter("productId");

                System.out.println("ID:" + id);
                Product product = dao.getProductById(Integer.parseInt(id));
                loginController.addCart.add(product);
                System.out.println("loginController.addCart: "+loginController.addCart.size());

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // searchProduct method
            String searchProductValue = request.getParameter("searchProduct");
            if (searchProductValue != null && searchProductValue.equals("true")) {
                String nameSearchProduct = request.getParameter("nameSearchProduct");
                try {
                    // Xử lý thêm sản phẩm vào cơ sở dữ liệu thông qua ProductDao
                    listProduct = dao.findProductByName(nameSearchProduct);
                    if (!listProduct.isEmpty()) {
                        // Set the listProduct as a request attribute
                        request.setAttribute("listProduct", listProduct);
                        // Forward the request to the JSP page
                        request.getRequestDispatcher("productUser.jsp").forward(request, response);

                    }
                } catch (ClassNotFoundException | IOException ex) {
                    Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                listProduct = dao.getAllProduct();
                System.out.println("listProduct.size" + listProduct.size());

                // Set the listProduct as a request attribute
                request.setAttribute("listProduct", listProduct);

                // Forward the request to the JSP page
                request.getRequestDispatcher("productUser.jsp").forward(request, response);
            } catch (ClassNotFoundException | ServletException | IOException ex) {
                Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String cartProductValue = request.getParameter("showCart");
            if (cartProductValue != null && cartProductValue.equals("true")) {
                // Set the listProduct as a request attribute
                request.setAttribute("listProduct", loginController.addCart);

                // Forward the request to the JSP page
                request.getRequestDispatcher("productCart.jsp").forward(request, response);
            }

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
