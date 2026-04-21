package com.prashant.jobapi;

import jakarta.validation.Valid;
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
        return jobService.getJobsById(id).orElseThrow(() -> new JobNotFoundException("Job not found " + id));
    }
    @PostMapping
    public Job createJob(@Valid @RequestBody Job job){
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

    @GetMapping("/location/{location}")
    public List<Job> findByLocation(@PathVariable String location){
        return jobService.findByLocation(location);
    }

    @GetMapping("/salary/{salary}")
    public List<Job> findBySalaryGreaterThanEqual(@PathVariable int salary){
        return jobService.findBySalaryGreaterThanEqual(salary);
    }
}
