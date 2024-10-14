package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConfig {
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/NewsDB", "root", "123456");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
