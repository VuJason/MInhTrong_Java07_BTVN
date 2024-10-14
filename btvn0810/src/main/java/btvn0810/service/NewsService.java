package btvn0810.service;

import java.util.List;

import btvn0810.repository.NewsRepository;
import entity.News;

public class NewsService {
	
	private NewsRepository newsRepository = new NewsRepository();
	
	public List<News> getAllNews() {
		return newsRepository.findAll();
	}
}
