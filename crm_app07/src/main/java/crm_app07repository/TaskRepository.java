package crm_app07repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crm_app07config.MysqlConfig;
import crm_app07entity.TaskEntity;


public class TaskRepository {
	public List<TaskEntity> findAll() {
		List<TaskEntity> listTasks = new ArrayList<TaskEntity>();
		String query = "SELECT t.id, t.name AS task_name, j.name AS job_name,  u.fullname, t.start_date, t.end_date, s.name AS status_name FROM tasks t JOIN users u ON t.user_id = u.id JOIN jobs j ON t.job_id = j.id JOIN status s ON t.status_id = s.id";

		Connection connection = MysqlConfig.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				TaskEntity taskEntity = new TaskEntity();
				taskEntity.setId(result.getInt("id"));
				taskEntity.setTaskName(result.getString("task_name"));
				taskEntity.setJobName(result.getString("job_name"));
				taskEntity.setFullName(result.getString("fullname"));
				taskEntity.setStartDate(result.getString("start_date"));
				taskEntity.setEndDate(result.getString("end_date"));
				taskEntity.setStatusName(result.getString("status_name"));

				listTasks.add(taskEntity);
			}

		} catch (Exception e) {
			System.out.println("findAll " + e.getLocalizedMessage());

		}
		return listTasks;
	}


	public int insertTask(String taskName, String startDate, String endDate, int userId, int jobId,
			int statusId) {
		int rowInsert = 0;
		String query = "INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id) VALUES (?,?,?,?,?,?)";

		Connection connection = MysqlConfig.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, taskName);
			statement.setString(2, startDate);
			statement.setString(3, endDate);
			statement.setInt(4, userId);
			statement.setInt(5, jobId);
			statement.setInt(6, statusId);

			rowInsert = statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertUser " + e.getLocalizedMessage());
		}

		return rowInsert;
	}
	
	
	public int deleteById(int id) {
		int rowDeleted = 0;
		String query = "DELETE FROM tasks t WHERE t.id = ?";
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
	
	
	
	public TaskEntity findById(int id) {
        TaskEntity taskEntity = null;
        String query = "SELECT t.id, t.name AS task_name, j.name AS job_name, u.fullname, t.start_date, t.end_date, s.name AS status_name FROM tasks t JOIN users u ON t.user_id = u.id JOIN jobs j ON t.job_id = j.id JOIN status s ON t.status_id = s.id WHERE t.id = ?";

        try (Connection connection = MysqlConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                taskEntity = new TaskEntity();
                taskEntity.setId(result.getInt("id"));
                taskEntity.setTaskName(result.getString("task_name"));
                taskEntity.setJobName(result.getString("job_name"));
                taskEntity.setFullName(result.getString("fullname"));
                taskEntity.setStartDate(result.getString("start_date"));
                taskEntity.setEndDate(result.getString("end_date"));
                taskEntity.setStatusName(result.getString("status_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskEntity;
    }

    // Cập nhật tác vụ
    public int updateTask(int id, String taskName, String startDate, String endDate, int userId, int jobId, int statusId) {
        String query = "UPDATE tasks SET name = ?, start_date = ?, end_date = ?, user_id = ?, job_id = ?, status_id = ? WHERE id = ?";
        int rowUpdated = 0;

        try (Connection connection = MysqlConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, taskName);
            statement.setString(2, startDate);
            statement.setString(3, endDate);
            statement.setInt(4, userId);
            statement.setInt(5, jobId);
            statement.setInt(6, statusId);
            statement.setInt(7, id);

            rowUpdated = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    
    
    public List<TaskEntity> findAllByEmail(String email) {
        List<TaskEntity> listTasks = new ArrayList<>();
        String query = "SELECT t.id, t.name AS task_name, j.name AS job_name, u.fullname, t.start_date, t.end_date, s.name AS status_name " +
                       "FROM tasks t " +
                       "JOIN users u ON t.user_id = u.id " +
                       "JOIN jobs j ON t.job_id = j.id " +
                       "JOIN status s ON t.status_id = s.id " +
                       "WHERE u.email = ?"; // Sửa để tìm theo email

        try (Connection connection = MysqlConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email); // Truyền giá trị email vào câu lệnh SQL
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                TaskEntity taskEntity = new TaskEntity();
                taskEntity.setId(result.getInt("id"));
                taskEntity.setTaskName(result.getString("task_name"));
                taskEntity.setJobName(result.getString("job_name"));
                taskEntity.setFullName(result.getString("fullname"));
                taskEntity.setStartDate(result.getString("start_date"));
                taskEntity.setEndDate(result.getString("end_date"));
                taskEntity.setStatusName(result.getString("status_name"));

                listTasks.add(taskEntity);
            }
        } catch (Exception e) {
            System.out.println("findAllByEmail " + e.getLocalizedMessage());
        }
        return listTasks;
    }

}
