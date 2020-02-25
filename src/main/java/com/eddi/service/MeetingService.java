package com.eddi.service;

import com.eddi.model.Department;
import com.eddi.model.Employee;
import com.eddi.model.Meeting;
import com.eddi.repository.DepartmentRepo;
import com.eddi.repository.EmployeeRepo;
import com.eddi.repository.MeetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
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

    public List<Meeting> findByTitleContaining(String topic) {
                return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(meetingRepo.findByTopicContaining(topic).iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public List<Meeting> findByOrganizedEmployeeContaining(String organizedEmployee) {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(meetingRepo.findByNameContaining(organizedEmployee).iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public List<Meeting> findByDepartmentNameContaining(String department) {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(meetingRepo.findByDepartmentNameContaining(department).iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public List<Meeting> findByDateSpendingBetween(String fromDate, String toDate) {
        Date from = null;
        Date to = null;
        try {
            from = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
            to = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
        }
        catch (Exception e) {
            return new ArrayList<>();
        }
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(meetingRepo.findByDateSpendingBetween(from, to).iterator(),
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
