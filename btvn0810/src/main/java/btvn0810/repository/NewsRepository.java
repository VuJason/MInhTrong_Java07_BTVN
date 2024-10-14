package btvn0810.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.MySqlConfig;
import entity.News;

public class NewsRepository {
	public List<News> findAll() {
		List<News> newsList = new ArrayList<News>();
		String query = "SELECT * FROM news";
		Connection conn = MySqlConfig.getConnection();
		try {
			PreparedStatement stm = conn.prepareStatement(query);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				News newsEntity = new News();
				newsEntity.setId(rs.getInt("id"));
				newsEntity.setTitle(rs.getString("title"));
				newsEntity.setContent(rs.getString("content"));
				newsEntity.setImage_url(rs.getString("image_url"));
				newsList.add(newsEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return newsList;
	}
}
