package crm_app07controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_app07entity.JobEntity;
import crm_app07service.JobService;

@SuppressWarnings("serial")
@WebServlet(name = "jobController", urlPatterns = { "/jobs", "/job-add", "/job-update" })
public class JobController extends HttpServlet {

    private JobService jobService = new JobService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/jobs")) {
        	deleteJob(req, resp);
        } else if (path.equals("/job-add")) {
            showAddJobForm(req, resp);
        } else if (path.equals("/job-update")) {
            showEditJobForm(req, resp);
        } 
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        
        if (path.equals("/job-add")) {
            addJob(req, resp);
        } else if (path.equals("/job-update")) {
            updateJob(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "POST method is not supported by this URL");
        }
        
        
    }


    // Hiển thị form thêm công việc
    public void showAddJobForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("task-add.jsp").forward(req, resp);
    }

    // Thêm công việc mới
    public void addJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jobName = req.getParameter("jobName");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        
        String message = jobService.insertJobWithMessage(jobName, startDate, endDate);
        req.setAttribute("message", message);

        
        req.getRequestDispatcher("task-add.jsp").forward(req, resp);
    }

    // Hiển thị form cập nhật công việc
    public void showEditJobForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            JobEntity job = jobService.findJobById(Integer.parseInt(id));
            if (job != null) {
                req.setAttribute("job", job);
                req.getRequestDispatcher("task-update.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Job not found!");
                req.getRequestDispatcher("task.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "Invalid Job ID");
            req.getRequestDispatcher("task.jsp").forward(req, resp);
        }
    }

    // Cập nhật công việc
    public void updateJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String jobName = req.getParameter("jobName");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

       
        String message = jobService.updateJobWithMessage(id, jobName, startDate, endDate);
        req.setAttribute("message", message);

      
        resp.sendRedirect(req.getContextPath() + "/jobs");
    }
    
 // Xóa công việc theo ID
    private void deleteJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
           
            jobService.deleteJob(Integer.parseInt(id));
        }

       
        List<JobEntity> listJobs = jobService.listJob();     
        req.setAttribute("listJobs", listJobs);   
        req.getRequestDispatcher("task.jsp").forward(req, resp);
    }


}
