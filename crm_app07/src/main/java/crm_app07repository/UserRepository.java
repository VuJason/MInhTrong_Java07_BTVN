package crm_app07repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crm_app07config.MysqlConfig;
import crm_app07entity.UserEntity;
import utils.MD5;
import crm_app07entity.RoleEntity;
import crm_app07entity.TaskEntity;


public class UserRepository {
	public List<UserEntity> findByEmailAndPassword(String email, String password) {
		List<UserEntity> ListUsers = new ArrayList<UserEntity>();

		  String query = "SELECT u.*, r.name AS role_name " +
                  "FROM users u " +
                  "JOIN roles r ON r.id = u.role_id " +
                  "WHERE u.email = ? AND u.password = ?";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserEntity userEntity = new UserEntity();
				userEntity.setEmail(result.getString("email"));
				userEntity.setPassword(result.getString("password"));
				userEntity.setRolename(result.getString("role_name"));

				ListUsers.add(userEntity);

			}

		} catch (Exception e) {
			System.out.println("findByEmailAndPassword : " + e.getLocalizedMessage());
		}

		return ListUsers;
	}

	// List User
	public List<UserEntity> findAll() {
		List<UserEntity> listUserTable = new ArrayList<UserEntity>();

		String query = "SELECT u.id, u.email, u.fullname, r.name FROM users u JOIN roles r ON u.role_id = r.id";
		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				UserEntity userEntity = new UserEntity();
				userEntity.setEmail(result.getString("email"));
				userEntity.setRolename(result.getString("name"));
				userEntity.setFullname(result.getString("fullname"));
				userEntity.setId(result.getInt("id"));

				listUserTable.add(userEntity);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return listUserTable;
	}

	public int deleteById(int id) {
		int rowDelete = 0;
		String query = "DELETE FROM users u WHERE u.id= ?";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);

			rowDelete = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteById : " + e.getLocalizedMessage());

		}
		return rowDelete;
	}

	public int insert(String email, String password, String fullname, int roleId) {
		int rowInsert = 0;
		String query = "INSERT INTO users(email,password,fullname,role_id)VALUES(?,?,?,?)";

		Connection connection = MysqlConfig.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			statement.setString(3, fullname);
			statement.setInt(4, roleId);

			rowInsert = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Insert : " + e.getLocalizedMessage());
		}

		return rowInsert;
	}
	
	public UserEntity findById(int id) {
	    UserEntity user = null;
	    String query = "SELECT u.id, u.email, u.fullname, u.password, r.name AS role_name " +
	                   "FROM users u JOIN roles r ON u.role_id = r.id WHERE u.id = ?";

	    Connection connection = MysqlConfig.getConnection();

	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, id);
	        ResultSet result = statement.executeQuery();

	        if (result.next()) {
	            user = new UserEntity();
	            user.setId(result.getInt("id"));
	            user.setEmail(result.getString("email"));
	            user.setFullname(result.getString("fullname"));
	            user.setPassword(result.getString("password"));
	         user.setRolename(result.getString("role_name"));
	          
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}


	
	public int updateUser(String email, String password, String fullname, int roleId, int id) {
	    int rowsUpdated = 0;
	    String query = "UPDATE users SET email = ?, password = ?, fullname = ?, role_id = ? WHERE id = ?";

	    Connection connection = MysqlConfig.getConnection();

	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, email);
	        statement.setString(2, password);
	        statement.setString(3, fullname);
	        statement.setInt(4, roleId);
	        statement.setInt(5, id);
	        rowsUpdated = statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return rowsUpdated;
	}

	

	public List<UserEntity> findByEmail(String email) {
	    List<UserEntity> listUsers = new ArrayList<UserEntity>();
	    String query = "SELECT u.*, r.name AS role_name " +
	                   "FROM users u " +
	                   "JOIN roles r ON r.id = u.role_id " +
	                   "WHERE u.email = ?";

	    Connection connection = MysqlConfig.getConnection();

	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, email);
	        ResultSet result = statement.executeQuery();

	        while (result.next()) {
	            UserEntity userEntity = new UserEntity();
	            userEntity.setEmail(result.getString("email"));
	            userEntity.setPassword(result.getString("password"));
	            userEntity.setRolename(result.getString("role_name"));

	            listUsers.add(userEntity);
	        }

	    } catch (Exception e) {
	        System.out.println("findByEmail : " + e.getLocalizedMessage());
	    }

	    return listUsers;
	}


}
