package crm_app07repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crm_app07config.MysqlConfig;
import crm_app07entity.StatusEntity;


public class StatusRepository {
	public List<StatusEntity> findAll() {
		List<StatusEntity> listStatus = new ArrayList<StatusEntity>();
		String query = "SELECT * FROM status";
		Connection connection = MysqlConfig.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				StatusEntity statusEntity = new StatusEntity();
				statusEntity.setId(result.getInt("id"));
				statusEntity.setStatusName(result.getString("name"));

				listStatus.add(statusEntity);
			}

		} catch (Exception e) {
			System.out.println("findAll " + e.getLocalizedMessage());

		}
		return listStatus;
	}
}
