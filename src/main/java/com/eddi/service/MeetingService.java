package com.eddi.service;

import com.eddi.model.Department;
import com.eddi.model.Employee;
import com.eddi.model.Meeting;
import com.eddi.repository.DepartmentRepo;
import com.eddi.repository.EmployeeRepo;
import com.eddi.repository.MeetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class MeetingService {
    @Autowired
    private MeetingRepo meetingRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public void save(Meeting meeting) {
        meetingRepo.save(meeting);

        System.out.println(meeting);
    }

    public List<Meeting> getAllMeeting() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(meetingRepo.findAll().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployee() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(employeeRepo.findAll().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public List<Department> getAllDepartment() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(departmentRepo.findAll().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }
}
