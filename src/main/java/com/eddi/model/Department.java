package com.eddi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "depID")
    Integer depID;

    @Column(name = "departmentName")
    String departmentName;

   // List<Employee> departmentEmployee;

    public Integer getDepID() {
        return depID;
    }

    public void setDepID(Integer depID) {
        this.depID = depID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

   /* public List<Employee> getDepartmentEmployee() {
        return departmentEmployee;
    }

    public void setDepartmentEmployee(List<Employee> departmentEmployee) {
        this.departmentEmployee = departmentEmployee;
    }*/
}