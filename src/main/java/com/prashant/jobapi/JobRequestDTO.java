package com.prashant.jobapi;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class JobRequestDTO {

    @NotBlank(message = "Title of company cannot be blank")
    private String jobTitle;
    @NotBlank(message = "Company cannot be blank")
    private String company;
    private String location;

    @Min(value = 0, message = "Salary should be greater then 0")
    private int salary;

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

}
