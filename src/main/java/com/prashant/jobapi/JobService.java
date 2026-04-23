package com.prashant.jobapi;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    public List<JobDTO> getJobs(){
        return jobRepository.findAll().stream().map(this :: convertToDTO).toList();
    }

    public Optional<Job> getJobsById(Long id){
        return jobRepository.findById(id);
    }

    public JobDTO createJob(JobRequestDTO jobRequestDTO){
         return convertToDTO(jobRepository.save(convertToEntity(jobRequestDTO)));
    }

    public void deleteJob(Long id){
         jobRepository.deleteById(id);
    }

    public Job updateJob(Long id, Job job){
        Job existingJob = getJobsById(id).orElseThrow(() -> new NotFoundException("Job not found " + id));
        existingJob.setTitle(job.getTitle());
        existingJob.setCompany(job.getCompany());
        existingJob.setLocation(job.getLocation());
        existingJob.setSalary(job.getSalary());
        return jobRepository.save(existingJob);
    }

    public List<Job> findByLocation(String location){
        return jobRepository.findByLocation(location);
    }

    public List<Job> findBySalaryGreaterThanEqual(int salary){
            List<Job> jobs  = jobRepository.findBySalaryGreaterThanEqual(salary);
            jobs.removeIf(x -> (x.getSalary() < salary));
            return jobs;
    }

    public JobDTO convertToDTO(Job job) {
        return new JobDTO(job);
    }

    public Job convertToEntity(JobRequestDTO jobRequestDTO) {
        Job job = new Job();
        job.setSalary(jobRequestDTO.getSalary());
        job.setLocation(jobRequestDTO.getLocation());
        job.setCompany(jobRequestDTO.getCompany());
        job.setTitle(jobRequestDTO.getJobTitle());
        return job;
    }
}
