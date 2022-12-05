package com.eddi.unit;

import com.eddi.model.Department;
import com.eddi.model.Employee;
import com.eddi.model.Meeting;
import com.eddi.model.Report;
import com.eddi.model.Role;
import com.eddi.model.Status;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MeetingTest {

    @Test
    void getId() {
        final long ID = 1L;

        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(ID, new Date(), "Test_meeting", department, employee, report, employeeList);

        Long actual = meeting.getId();

        assertNotNull(actual);
        assertNotNull(actual, String.valueOf(ID));
    }

    @Test
    void setId() {
        final long ID = 1L;
        final long newId = 2L;

        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(ID, new Date(), "Test_meeting", department, employee, report, employeeList);

        meeting.setId(newId);
        long actual = meeting.getId();

        assertNotNull(actual);
        assertNotNull(actual, String.valueOf(newId));
    }

    @Test
    void getDateSpending() {
        final String PATTERN = "yyyy-MM-dd";
        final Date date = new Date();

        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(1L, date, "Test_meeting", department, employee, report, employeeList);

        String actual = meeting.getDateSpending();

        assertNotNull(actual);
        assertNotNull(actual, new SimpleDateFormat(PATTERN).format(date));
    }

    @Test
    void setDateSpending() {
        final String PATTERN = "yyyy-MM-dd";
        final Date date = new Date();
        final Date newDate = new Date();

        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(1L, date, "Test_meeting", department, employee, report, employeeList);

        meeting.setDateSpending(new SimpleDateFormat(PATTERN).format(newDate));
        String actual = meeting.getDateSpending();

        assertNotNull(actual);
        assertNotNull(actual, new SimpleDateFormat(PATTERN).format(newDate));
    }

    @Test
    void getTopic() {
        final String topic = "Test_meeting";

        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(1L, new Date(), topic, department, employee, report, employeeList);

        String actual = meeting.getTopic();

        assertNotNull(actual);
        assertNotNull(actual, topic);
    }

    @Test
    void setTopic() {
        final String topic = "Test_meeting";
        final String newTopic = "New_Test_meeting";

        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(1L, new Date(), topic, department, employee, report, employeeList);

        meeting.setTopic(newTopic);
        String actual = meeting.getTopic();

        assertNotNull(actual);
        assertNotNull(actual, newTopic);
    }

    @Test
    void getDepartment() {
        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(1L, new Date(), "Test_meeting", department, employee, report, employeeList);

        Department actual = meeting.getDepartment();

        assertNotNull(actual);
        assertEquals(actual, department);
    }

    @Test
    void setDepartment() {
        Department newDepartment = new Department(2L, "New_Department");

        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(1L, new Date(), "Test_meeting", department, employee, report, employeeList);

        meeting.setDepartment(newDepartment);
        Department actual = meeting.getDepartment();

        assertNotNull(actual);
        assertEquals(actual, newDepartment);
    }

    @Test
    void getOrganizedEmployee() {
        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(1L, new Date(), "Test_meeting", department, employee, report, employeeList);

        Employee actual = meeting.getOrganizedEmployee();

        assertNotNull(actual);
        assertEquals(actual, employee);
    }

    @Test
    void setOrganizedEmployee() {
        Department newDepartment = new Department(2L, "New_Department");
        Employee newEmployee = new Employee(2L, "New_Test_name", new Date(), "new@1.ru", "newTestName", "12345", Role.ADMIN, Status.ACTIVE, newDepartment);

        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(1L, new Date(), "Test_meeting", department, employee, report, employeeList);

        meeting.setOrganizedEmployee(newEmployee);
        Employee actual = meeting.getOrganizedEmployee();

        assertNotNull(actual);
        assertEquals(actual, newEmployee);
    }

    @Test
    void getReport() {
        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(1L, new Date(), "Test_meeting", department, employee, report, employeeList);

        Report actual = meeting.getReport();

        assertNotNull(actual);
        assertEquals(actual, report);
    }

    @Test
    void setReport() {
        Department newDepartment = new Department(2L, "New_Department");
        Employee newEmployee = new Employee(2L, "New_Test_name", new Date(), "new@1.ru", "newTestName", "12345", Role.ADMIN, Status.ACTIVE, newDepartment);
        Report newReport = new Report(2L, "New_Report", newEmployee, "New_Content", new Date());

        Department department = new Department(1L, "Test");
        Employee employee = new Employee(1L, "Test_name", new Date(), "1@1.ru", "testName", "123", Role.USER, Status.ACTIVE, department);
        Report report = new Report(1L, "Report", employee, "Content", new Date());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        Meeting meeting = new Meeting(1L, new Date(), "Test_meeting", department, employee, report, employeeList);

        meeting.setReport(newReport);
        Report actual = meeting.getReport();

        assertNotNull(actual);
        assertEquals(actual, newReport);
    }
}