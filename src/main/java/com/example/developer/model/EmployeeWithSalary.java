package com.example.developer.model;

public class EmployeeWithSalary extends Employee{

    private Long anualSalary;

    public Long getAnualSalary() {
        return anualSalary;
    }

    public void setAnualSalary(Long anualSalary) {
        this.anualSalary = anualSalary;
    }

    public void setEmployee(Employee employee){
        setId(employee.getId());
        setEmployee_name(employee.getEmployee_name());
        setEmployee_salary(employee.getEmployee_salary());
        setEmployee_age(employee.getEmployee_age());
        setProfile_image(employee.getProfile_image());
    }
}
