package com.prashant.jobapi;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    public List<Job> getJobs(){
        return jobRepository.findAll();
    }

    public Optional<Job> getJobsById(Long id){
        return jobRepository.findById(id);
    }

    public Job createJob(Job job){
         return jobRepository.save(job);
    }

    public void deleteJob(Long id){
         jobRepository.deleteById(id);
    }

    public Job updateJob(Long id, Job job){
        Job existingJob = getJobsById(id).orElseThrow(() -> new RuntimeException("Job not found"));
        existingJob.setTitle(job.getTitle());
        existingJob.setCompany(job.getCompany());
        existingJob.setLocation(job.getLocation());
        existingJob.setSalary(job.getSalary());
        return jobRepository.save(existingJob);
    }
}
