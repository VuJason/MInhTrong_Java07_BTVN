package crm_app07repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crm_app07config.MysqlConfig;
import crm_app07entity.JobEntity;

public class JobRepository {
	public List<JobEntity> findAll() {
		List<JobEntity> listJobs = new ArrayList<JobEntity>();
		String query = "SELECT * FROM jobs";
		Connection connection = MysqlConfig.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				JobEntity jobEntity = new JobEntity();
				jobEntity.setId(result.getInt("id"));
				jobEntity.setJobName(result.getString("name"));
				jobEntity.setStartDate(result.getString("start_date"));
				jobEntity.setEndDate(result.getString("end_date"));

				listJobs.add(jobEntity);
			}
		} catch (Exception e) {
			System.out.println("findAll " + e.getLocalizedMessage());
		}

		return listJobs;
	}
	
	public int insertJob(String jobName, String startDate, String endDate) {
		int rowInsert = 0;
		String query = "INSERT INTO jobs (name, start_date, end_date) VALUES (?, ?, ?)";

		Connection connection = MysqlConfig.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, jobName);
			statement.setString(2, startDate);
			statement.setString(3, endDate);
			rowInsert = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertJob " + e.getLocalizedMessage());
		}

		return rowInsert;
	}
	
	public int deleteById(int id) {
		int rowDeleted = 0;
		String query = "DELETE FROM jobs u WHERE u.id = ?;";
		Connection connection = MysqlConfig.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteById " + e.getLocalizedMessage());
		}
		return rowDeleted;
	}
	
	
	
	public JobEntity findJobById(int id) {
	    JobEntity jobEntity = null;
	    String query = "SELECT * FROM jobs WHERE id = ?";

	    Connection connection = MysqlConfig.getConnection();
	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, id);

	        ResultSet result = statement.executeQuery();
	        if (result.next()) {
	            jobEntity = new JobEntity();
	            jobEntity.setId(result.getInt("id"));
	            jobEntity.setJobName(result.getString("name"));
	            jobEntity.setStartDate(result.getString("start_date"));
	            jobEntity.setEndDate(result.getString("end_date"));
	        }
	    } catch (Exception e) {
	        System.out.println("findJobById " + e.getLocalizedMessage());
	    }

	    return jobEntity;
	}

	
	public int updateJob(int id, String jobName, String startDate, String endDate) {
	    int rowUpdated = 0;
	    String query = "UPDATE jobs SET name = ?, start_date = ?, end_date = ? WHERE id = ?";

	    Connection connection = MysqlConfig.getConnection();
	    try {
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, jobName);
	        statement.setString(2, startDate);
	        statement.setString(3, endDate);
	        statement.setInt(4, id);

	        rowUpdated = statement.executeUpdate();
	    } catch (Exception e) {
	        System.out.println("updateJob " + e.getLocalizedMessage());
	    }

	    return rowUpdated;
	}

	
}
