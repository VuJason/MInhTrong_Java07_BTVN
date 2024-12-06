package crm_app07controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_app07entity.JobEntity;
import crm_app07entity.StatusEntity;
import crm_app07entity.TaskEntity;
import crm_app07entity.UserEntity;
import crm_app07service.TaskService;
@WebServlet(name = "ProfileController", urlPatterns = { "/profile", "/profile-edit" })
public class ProfileController extends HttpServlet {
    private TaskService service = new TaskService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/profile")) {
            showProfile(req, resp);
        } else if (path.equals("/profile-edit")) {
            showEditTaskForm(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/profile-edit")) {
            handleEditTask(req, resp);
        }
    }

    // Hiển thị thông tin profile và danh sách công việc theo email lấy từ cookie
    private void showProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy email từ cookie
        String email = getEmailFromCookies(req);
        if (email == null) {
            // Nếu không tìm thấy email trong cookie, chuyển hướng về trang đăng nhập hoặc thông báo lỗi
        	 req.getRequestDispatcher("profile.jsp").forward(req, resp);
            return;
        }

        // Lấy danh sách công việc theo email
        List<TaskEntity> listTasks = service.getTasksByEmail(email);

        req.setAttribute("profile", listTasks);
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }

    // Lấy email từ cookies
    private String getEmailFromCookies(HttpServletRequest req) {
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if ("ckEmail".equals(cookie.getName())) { // Kiểm tra cookie với tên là "userEmail"
                    return cookie.getValue();  // Trả về giá trị của email
                }
            }
        }
        return null;  // Nếu không tìm thấy cookie email, trả về null
    }

    // Hiển thị form cập nhật công việc
    private void showEditTaskForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            TaskEntity task = service.getTaskById(Integer.parseInt(id));
            List<JobEntity> listJob = service.listJob();
            List<UserEntity> listUser = service.getAllUserTable();
            List<StatusEntity> listStatus = service.listStatus();

            req.setAttribute("task", task);
            req.setAttribute("listJob", listJob);
            req.setAttribute("listUser", listUser);
            req.setAttribute("listStatus", listStatus);

            req.getRequestDispatcher("profile-edit.jsp").forward(req, resp);
        }
    }

    // Xử lý form cập nhật công việc
    private void handleEditTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String taskName = req.getParameter("taskName");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        int userId = Integer.parseInt(req.getParameter("user") != null ? req.getParameter("user") : "0");
        int jobId = Integer.parseInt(req.getParameter("job") != null ? req.getParameter("job") : "0");
        int statusId = Integer.parseInt(req.getParameter("status") != null ? req.getParameter("status") : "0");

        boolean updated = service.updateTask(id, taskName, startDate, endDate, userId, jobId, statusId);
        if (updated) {
            resp.sendRedirect(req.getContextPath() + "/profile");
        } else {
            req.setAttribute("error", "Update failed. Please try again.");
            showEditTaskForm(req, resp);
        }
    }
}
