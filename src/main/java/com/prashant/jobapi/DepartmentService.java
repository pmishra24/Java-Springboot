package com.prashant.jobapi;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository){
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void generateDepAndEmployee(){
        Department dept = new Department();
        dept.setName("Engineering");
        departmentRepository.save(dept);

        Employee emp = new Employee();
        emp.setName("John");
        dept.addEmployee(emp);
        employeeRepository.save(emp);

        // Use dept directly — both sides are synced
        System.out.println("Department: " + dept.getName());
        System.out.println("Employees: " + dept.getEmployeeList().size());
    }
}
