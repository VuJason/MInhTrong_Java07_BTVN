package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("loginform.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = req.getParameter("username");
		String passWord = req.getParameter("password");

		if (userName.equals("admin") && passWord.equals("123456")) {
			req.setAttribute("username", userName);
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);

		} else {

			req.setAttribute("message", "Sai tên username hoặc password");
			req.getRequestDispatcher("loginform.jsp").forward(req, resp);
		}

	}

}
