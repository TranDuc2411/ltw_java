package controller;

import dbhanddle.AccountApiDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountApi;

//@WebServlet("/login")
public class loginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển hướng đến trang đăng nhập
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountApiDao account = new AccountApiDao();
        AccountApi acc = null;
        try {
            acc = account.findAccountApiByUsernameAndPassword(username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(acc);// Xử lý lỗi tại đây nếu cần thiết
        
//        response.sendRedirect("index.html");
            if (acc != null) {
                // Đăng nhập thành công
                // Lưu thông tin đăng nhập vào session để duy trì trạng thái đăng nhập
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("checklogin", true);

                // Chuyển hướng đến trang home.jsp
                response.sendRedirect("home.jsp");
            } else {
                // Đăng nhập không thành công, chuyển hướng đến trang đăng nhập
                response.sendRedirect("index.html");
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
