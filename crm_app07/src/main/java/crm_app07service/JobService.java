package crm_app07service;

import java.util.List;
import crm_app07entity.JobEntity;
import crm_app07repository.JobRepository;

public class JobService {
    private JobRepository jobRepository = new JobRepository();

    
    public List<JobEntity> listJob() {
        return jobRepository.findAll();
    }

    // Thêm công việc mới
    public String insertJobWithMessage(String jobName, String startDate, String endDate) {
        boolean isSuccess = jobRepository.insertJob(jobName, startDate, endDate) > 0;
        if (isSuccess) {
            return "Job added successfully!";
        } else {
            return "Failed to add job. Please try again.";
        }
    }

    // Xóa công việc theo ID
    public boolean deleteJob(int id) {
        return jobRepository.deleteById(id) > 0;
    }

    // Tìm công việc theo ID
    public JobEntity findJobById(int id) {
        return jobRepository.findJobById(id);
    }

    // Cập nhật thông tin công việc
    public String updateJobWithMessage(int id, String jobName, String startDate, String endDate) {
        boolean isSuccess = jobRepository.updateJob(id, jobName, startDate, endDate) > 0;
        if (isSuccess) {
            return "Job updated successfully!";
        } else {
            return "Failed to update job. Please try again.";
        }
    }
}
