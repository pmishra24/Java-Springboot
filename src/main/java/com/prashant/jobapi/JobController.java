package com.prashant.jobapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getJobs(){
        return jobService.getJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobService.getJobsById(id).orElseThrow(() -> new RuntimeException("Job not found"));
    }
    @PostMapping
    public Job createJob(@RequestBody Job job){
        return jobService.createJob(job);
    }
    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id){
         jobService.deleteJob(id);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job job){
        return jobService.updateJob(id, job);
    }
}
