package com.example.developer.model.crud;

import com.example.developer.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll ();
    Employee findById(int id);
}
