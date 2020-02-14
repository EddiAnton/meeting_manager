package com.eddi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "department_name")
    String department_name;

    @OneToMany(mappedBy = "department")
    List<Employee> employees;

    @OneToMany(mappedBy = "department")
    List<Meeting> meetings;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return department_name;
    }

    public void setDepartmentName(String departmentName) {
        this.department_name = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> departmentEmployee) {
        this.employees = departmentEmployee;
    }
}