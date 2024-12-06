package crm_app07controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DemoCookieController", urlPatterns = "/demo-cookie")
public class DemoCookieController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		Cookie demoCk = new Cookie("demo", URLEncoder.encode("Hello Cookie","UTF-8"));
//		resp.addCookie(demoCk);

		Cookie[] cookies = req.getCookies();
		String valueCookieDemo = "";

		for (Cookie item : cookies) {
			String name = item.getName();
			String value = URLDecoder.decode(item.getValue(), "UTF-8");
			if (name.equals("demo")) {
				valueCookieDemo = value;
			}
		}
		System.out.println("demo" + valueCookieDemo);
	}
}
