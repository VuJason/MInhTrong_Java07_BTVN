package crm_app07controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_app07entity.JobEntity;
import crm_app07entity.StatusEntity;
import crm_app07entity.TaskEntity;
import crm_app07entity.UserEntity;
import crm_app07service.TaskService;


@WebServlet(name = "taskController", urlPatterns = { "/tasks", "/task-add", "/task-update" })
public class TaskController extends HttpServlet {
    private TaskService taskService = new TaskService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/tasks")) {
            deleteTask(req, resp);
        } else if (path.equals("/task-add")) {
            showAddTaskForm(req, resp);
        } else if (path.equals("/task-update")) {
            showEditTaskForm(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/task-add")) {
            handleAddTask(req, resp);
        } else if (path.equals("/task-update")) {
            handleEditTask(req, resp);
        }
    }

 // Delete
    private void deleteTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = taskService.getRoleFromCookies(req); // Lấy vai trò từ cookie
        String id = req.getParameter("id");

        // Nếu người dùng là ROLE_USER, không cho phép xóa Task
        if ("ROLE_USER".equals(role)) {
            // Chỉ tải danh sách Task, không thực hiện xóa
            List<TaskEntity> listTasks = taskService.task(); // Lấy danh sách Task
            req.setAttribute("listTasks", listTasks);
            req.getRequestDispatcher("groupwork.jsp").forward(req, resp);
            return;
        }

        // Nếu có ID và vai trò hợp lệ (ROLE_ADMIN hoặc ROLE_MANAGER), thực hiện xóa
        if (id != null) {
            taskService.deleteTask(Integer.parseInt(id));
        }

        // Tải danh sách Task sau khi xóa
        List<TaskEntity> listTasks = taskService.task();
        req.setAttribute("listTasks", listTasks);
        req.getRequestDispatcher("groupwork.jsp").forward(req, resp);
    }


    // Add form
    private void showAddTaskForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String role = taskService.getRoleFromCookies(req);

        if (!"ROLE_ADMIN".equals(role) && !"ROLE_MANAGER".equals(role)) {
        	  req.getRequestDispatcher("error-403.jsp").forward(req, resp); 
            return;
        }

        List<JobEntity> listJob = taskService.listJob();
        List<UserEntity> listUser = taskService.getAllUserTable();
        List<StatusEntity> listStatus = taskService.listStatus();

        req.setAttribute("listJob", listJob);
        req.setAttribute("listUser", listUser);
        req.setAttribute("listStatus", listStatus);

        req.getRequestDispatcher("groupwork-add.jsp").forward(req, resp);
    }


    // Add
    private void handleAddTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 String role = taskService.getRoleFromCookies(req);

        if (!"ROLE_ADMIN".equals(role) && !"ROLE_MANAGER".equals(role)) {
        	  req.getRequestDispatcher("error-403.jsp").forward(req, resp);
            return;
        }

        String taskName = req.getParameter("taskName");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        int userId = Integer.parseInt(req.getParameter("user") != null ? req.getParameter("user") : "0");
        int jobId = Integer.parseInt(req.getParameter("job") != null ? req.getParameter("job") : "0");
        int statusId = Integer.parseInt(req.getParameter("status") != null ? req.getParameter("status") : "0");

        taskService.addTask(taskName, startDate, endDate, userId, jobId, statusId);

        resp.sendRedirect(req.getContextPath() + "/tasks");
    }


    // Update form
    private void showEditTaskForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            
            TaskEntity listTask = taskService.getTaskById(Integer.parseInt(id));
           
                List<JobEntity> listJob = taskService.listJob();
                List<UserEntity> listUser = taskService.getAllUserTable();
                List<StatusEntity> listStatus = taskService.listStatus();

                req.setAttribute("task", listTask);
                req.setAttribute("listJob", listJob);
                req.setAttribute("listUser", listUser);
                req.setAttribute("listStatus", listStatus);

                req.getRequestDispatcher("groupwork-update.jsp").forward(req, resp);
            
        }
    }

    // Update
    private void handleEditTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String taskName = req.getParameter("taskName");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        int userId = Integer.parseInt(req.getParameter("user") != null ? req.getParameter("user") : "0");
        int jobId = Integer.parseInt(req.getParameter("job") != null ? req.getParameter("job") : "0");
        int statusId = Integer.parseInt(req.getParameter("status") != null ? req.getParameter("status") : "0");

        boolean updated = taskService.updateTask(id, taskName, startDate, endDate, userId, jobId, statusId);
        if (updated) {
            
            resp.sendRedirect(req.getContextPath() + "/tasks");
        } else {
            
            req.setAttribute("error", "Update failed. Please try again.");
            showEditTaskForm(req, resp);
        }
    }
}
