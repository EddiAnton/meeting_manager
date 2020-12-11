package com.eddi.repository;

import com.eddi.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employee WHERE id IN (SELECT employee_id FROM participants WHERE meeting_id=?1)",
            nativeQuery = true)
    public List<Employee> findByMeetingAllEmployees(Integer id);

    @Query(value = "SELECT * FROM employee ORDER BY id DESC;",
            nativeQuery = true)
    public List<Employee> findAllEmployee();
}