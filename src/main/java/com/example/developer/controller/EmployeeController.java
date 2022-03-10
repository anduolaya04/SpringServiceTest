package com.example.developer.controller;


import com.example.developer.DeveloperApplication;
import com.example.developer.model.Employee;
import com.example.developer.model.EmployeeWithSalary;
import com.example.developer.model.JSONData;
import com.example.developer.model.crud.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    private JSONData jsonData = new JSONData();
    private static final String urlEmployees =  "http://dummy.restapiexample.com/api/v1/employees";
    private static final Logger log = LoggerFactory.getLogger(DeveloperApplication.class);

    @Autowired
    private EmployeeRepository repository;

    @CrossOrigin
    @GetMapping
    public List<EmployeeWithSalary> getEmployees(){

        List<EmployeeWithSalary> employeeWithSalaries = new ArrayList<>();
        List<Employee> employees = repository.findAll();

        for (Employee employee:
             employees) {
            EmployeeWithSalary employeeWithSalary = new EmployeeWithSalary();
            employeeWithSalary.setEmployee(employee);
            employeeWithSalary.setAnualSalary(Long.valueOf(employee.getEmployee_salary()) * 12);

            employeeWithSalaries.add(employeeWithSalary);
        }

        return employeeWithSalaries;
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public EmployeeWithSalary getEmployeeById(@PathVariable int id){

        EmployeeWithSalary employeeWithSalary = new EmployeeWithSalary();
        Employee employee = repository.findById(id);

        employeeWithSalary.setEmployee(employee);
        employeeWithSalary.setAnualSalary(Long.valueOf(employee.getEmployee_salary()) * 12);

        return employeeWithSalary;
    }
}
