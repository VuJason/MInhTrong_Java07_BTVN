package crm_app07filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebFilter(filterName = "authenFilter", urlPatterns = { "/users", "/roles", "/tasks", "/jobs" })
public class AuthenticationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        boolean isAuthenticated = false;
        String role = null;

        // Lấy danh sách cookie và kiểm tra quyền
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("authen".equals(cookie.getName())) {
                    role = cookie.getValue();
                    isAuthenticated = true;
                    break;
                }
            }
        }

        // Nếu không xác thực, chuyển hướng đến trang login
        if (!isAuthenticated) {
            res.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Kiểm tra quyền truy cập dựa trên role và URL
        String path = req.getServletPath();
        if (isAccessAllowed(role, path)) {
            chain.doFilter(req, res); 
        } else {
        	 req.getRequestDispatcher("error-403.jsp").forward(req, res);
        }
    }

   
 
    private boolean isAccessAllowed(String role, String path) {
        switch (role) {
            case "ROLE_ADMIN":
                return true; 
            case "ROLE_MANAGER":
                return path.equals("/tasks") || path.equals("/jobs") || path.equals("/users");
            case "ROLE_USER":
                return path.equals("/tasks"); 
            default:
                return false; 
        }
    }
}
