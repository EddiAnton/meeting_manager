package com.eddi.service;

import com.eddi.model.Employee;
import com.eddi.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> findByMeetingAllEmployees(String meetingId) {
        Integer id = Integer.parseInt(meetingId);
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
        employeeRepo.save(employee);
    }
}
