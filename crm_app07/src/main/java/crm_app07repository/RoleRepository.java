package crm_app07repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crm_app07config.MysqlConfig;
import crm_app07entity.RoleEntity;

public class RoleRepository {
	public List<RoleEntity> findAllRole() {
		List<RoleEntity> listRole = new ArrayList<RoleEntity>();

		String query = "SELECT * FROM roles r";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				RoleEntity roleEntity = new RoleEntity();
				roleEntity.setId(result.getInt("id"));
				roleEntity.setName(result.getString("name"));
				roleEntity.setDescription(result.getString("description"));
				listRole.add(roleEntity);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return listRole;

	}
	
	public int insertRoles(String name, String description) {
		int rowInsert = 0;
		String query = "INSERT INTO roles (name , description) VALUES (?, ?)";
		
		Connection connection = MysqlConfig.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, description);
		
			rowInsert = statement.executeUpdate();
			
		} catch (Exception e) {
			 System.out.println("Insert : " + e.getLocalizedMessage());
		}
		
		return rowInsert;
	}
	
	
	public int deleteByRoleId(int roleId) {
		int rowDelete = 0;
		String query = "DELETE FROM roles r WHERE r.id= ?";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, roleId);

			rowDelete = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteById : " + e.getLocalizedMessage());

		}
		return rowDelete;
	}
	
	
	public RoleEntity findRoleById(int roleId) {
	    RoleEntity roleEntity = null;
	    String query = "SELECT * FROM roles WHERE id = ?";
	    Connection connection = MysqlConfig.getConnection();

	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, roleId);
	        ResultSet result = statement.executeQuery();

	        if (result.next()) {
	            roleEntity = new RoleEntity();
	            roleEntity.setId(result.getInt("id"));
	            roleEntity.setName(result.getString("name"));
	            roleEntity.setDescription(result.getString("description"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return roleEntity;
	}

	public int updateRole(int roleId, String name, String description) {
	    int rowsAffected = 0;
	    String query = "UPDATE roles SET name = ?, description = ? WHERE id = ?";

	    Connection connection = MysqlConfig.getConnection();

	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, name);
	        statement.setString(2, description);
	        statement.setInt(3, roleId);

	        rowsAffected = statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return rowsAffected;
	}


}
