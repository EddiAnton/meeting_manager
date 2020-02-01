package com.eddi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "departmentName")
    String departmentName;

    @OneToMany(mappedBy = "department")
    List<Employee> employees;

    public Integer getDepID() {
        return id;
    }

    public void setDepID(Integer depID) {
        this.id = depID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> departmentEmployee) {
        this.employees = departmentEmployee;
    }
}