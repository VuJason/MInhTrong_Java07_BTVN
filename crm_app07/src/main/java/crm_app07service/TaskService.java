package crm_app07service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import crm_app07entity.JobEntity;
import crm_app07entity.StatusEntity;
import crm_app07entity.TaskEntity;
import crm_app07entity.UserEntity;
import crm_app07repository.JobRepository;
import crm_app07repository.StatusRepository;
import crm_app07repository.TaskRepository;
import crm_app07repository.UserRepository;

public class TaskService {
	private TaskRepository taskRepository = new TaskRepository();
	private JobRepository jobRepository = new JobRepository();
	private UserRepository userRepository = new UserRepository();
	private StatusRepository statusRepository = new StatusRepository();

	public List<TaskEntity> task() {
		List<TaskEntity> listTasks = taskRepository.findAll();
		return listTasks;
	}

	public boolean addTask(String taskName, String startDate, String endDate, int userId, int jobId, int statusId) {
		return taskRepository.insertTask(taskName, startDate, endDate, userId, jobId, statusId) > 0;
	}

	public boolean deleteTask(int id) {
		int count = taskRepository.deleteById(id);
		return count > 0;
	}

	public TaskEntity getTaskById(int id) {
		return taskRepository.findById(id);
	}

	public boolean updateTask(int id, String taskName, String startDate, String endDate, int userId, int jobId,
			int statusId) {
		int rowUpdated = taskRepository.updateTask(id, taskName, startDate, endDate, userId, jobId, statusId);
		return rowUpdated > 0;
	}

	public List<JobEntity> listJob() {
		List<JobEntity> listJob = jobRepository.findAll();
		return listJob;
	}

	public List<UserEntity> getAllUserTable() {
		List<UserEntity> listUsers = userRepository.findAll();
		return listUsers;
	}

	public List<StatusEntity> listStatus() {
		List<StatusEntity> listStatus = statusRepository.findAll();
		return listStatus;
	}
	
	public String getRoleFromCookies(HttpServletRequest req) {
	    if (req.getCookies() != null) {
	        for (Cookie cookie : req.getCookies()) {
	            if ("authen".equals(cookie.getName())) { 
	                return cookie.getValue();
	            }
	        }
	    }
	    return null;
	}
	
	public List<TaskEntity> getTasksByEmail(String email) {
	    return taskRepository.findAllByEmail(email);
	}


}
