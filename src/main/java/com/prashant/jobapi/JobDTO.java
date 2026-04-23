package com.prashant.jobapi;

public class JobDTO {
        private Long id;
        private String jobTitle;
        private String company;
        private String location;
        private int salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public JobDTO(Job job){
        this.setId(job.getId());
        this.setCompany(job.getCompany());
        this.setSalary(job.getSalary());
        this.setJobTitle(job.getTitle());
    }
}
