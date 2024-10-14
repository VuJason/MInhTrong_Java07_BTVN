package btvn0810.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import btvn0810.service.NewsService;
import entity.News;

@WebServlet(name="newsController", urlPatterns = {"/news"})
public class NewsController extends HttpServlet{
	
	private NewsService newsService = new NewsService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<News> listNews = newsService.getAllNews();
		req.setAttribute("news", listNews);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
