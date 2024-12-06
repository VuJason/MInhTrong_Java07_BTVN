package crm_app07controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_app07service.LoginService;
import crm_app07service.UserService;

@WebServlet(name = "loginController", urlPatterns = { "/login", "/logout", "/register" })
public class LoginController extends HttpServlet {
    private LoginService loginService = new LoginService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if ("/logout".equals(path)) {
            loginService.logout(req, resp);
            resp.sendRedirect(req.getContextPath() + "/login");
        } else if ("/register".equals(path)) {
            // Chuyển hướng tới trang đăng ký
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else {
            // Xử lý yêu cầu login
            String email = "";
            String password = "";

            // Lấy thông tin từ cookie (nếu có)
            if (req.getCookies() != null) {
                for (var cookie : req.getCookies()) {
                    if ("ckEmail".equals(cookie.getName())) {
                        email = cookie.getValue();
                    }
                    if ("ckPassword".equals(cookie.getName())) {
                        password = cookie.getValue();
                    }
                }
            }

            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if ("/register".equals(path)) {
            // Xử lý đăng ký
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String fullname = req.getParameter("fullname");

            // Mặc định role là ROLE_USER
            int roleId = 3; // Giả sử 3 là ID cho ROLE_USER trong database

            boolean isRegistered = userService.register(email, password, fullname, roleId);

            if (isRegistered) {
                resp.sendRedirect(req.getContextPath() + "/login");
            } else {
                resp.sendRedirect(req.getContextPath() + "/register");
            }
        } else {
            // Xử lý đăng nhập
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String remember = req.getParameter("remember");

            boolean isSuccess = loginService.checkLogin(email, password, remember, resp, req);

            if (!isSuccess) {
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            }

            String role = loginService.getRoleName(email);

            if ("ROLE_ADMIN".equals(role)) {
                resp.sendRedirect(req.getContextPath() + "/users");
            } else if ("ROLE_MANAGER".equals(role)) {
                resp.sendRedirect(req.getContextPath() + "/users");
            } else if ("ROLE_USER".equals(role)) {
                resp.sendRedirect(req.getContextPath() + "/tasks");
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        }
    }
}
