package com.prashant.jobapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    public List<Job> findByLocation(String location);
    public List<Job> findBySalaryGreaterThanEqual(int salary);

    @Query("select j from job j join fetch j.skillList")
    public List<Job> findAllJobsWithSkills();
}
