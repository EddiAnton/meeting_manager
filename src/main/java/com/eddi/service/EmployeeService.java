package com.eddi.service;

import com.eddi.config.SecurityConfig;
import com.eddi.model.Employee;
import com.eddi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {

    @Autowired
    private SecurityConfig securityConfig;

    private final EmployeeRepository employeeRepo;

    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> findByMeetingAllEmployees(String meetingId) {
        Long id = Long.parseLong(meetingId);
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(employeeRepo.findByMeeting(id).iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployee() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(employeeRepo.findAll().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployeeDesc() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(employeeRepo.findAllDesc().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public void saveEmployee(Employee employee) {
        String passwordHash = securityConfig.passwordEncoder().encode(employee.getPassword());
        employee.setPassword(passwordHash);
        employeeRepo.save(employee);
    }
}
