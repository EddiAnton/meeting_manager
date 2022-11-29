package com.eddi.repository;

import com.eddi.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Optional<Employee> findByLogin(String login);

    @Query(value = "SELECT * FROM employee WHERE id IN (SELECT employee_id FROM participants WHERE meeting_id=?1)",
            nativeQuery = true)
    List<Employee> findByMeeting(Integer id);

    @Query(value = "SELECT * FROM employee ORDER BY id DESC;",
            nativeQuery = true)
    List<Employee> findAllDesc();
}
