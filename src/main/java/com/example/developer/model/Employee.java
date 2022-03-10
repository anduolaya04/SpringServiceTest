package com.example.developer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    protected int id;
    protected String employee_name;
    protected String employee_salary;
    protected int employee_age;
    protected String profile_image;

    public Employee() {
    }

    public Employee(int id, String employee_name, String employee_salary, int employee_age, String profile_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_salary='" + employee_salary + '\'' +
                ", employee_age=" + employee_age +
                ", profile_image='" + profile_image + '\'' +
                '}';
    }
}
