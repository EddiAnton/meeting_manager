package com.eddi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer depID;
    String departmentName;
    List<Employee> departmentEmployee;

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

    public List<Employee> getDepartmentEmployee() {
        return departmentEmployee;
    }

    public void setDepartmentEmployee(List<Employee> departmentEmployee) {
        this.departmentEmployee = departmentEmployee;
    }
}