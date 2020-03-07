package com.eddi.service;

import com.eddi.model.Employee;
import com.eddi.repository.EmployeeRepo;
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
    private EmployeeRepo employeeRepo;

    public List<Employee> findByMeetingAllEmployees(String meetingId) {
        Integer id = Integer.parseInt(meetingId);
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(employeeRepo.findByMeetingAllEmployees(id).iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }
}
