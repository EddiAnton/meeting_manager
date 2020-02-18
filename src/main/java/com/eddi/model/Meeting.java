package com.eddi.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "meeting")
public class Meeting {
    private static final String PATTERN = "dd-MM-yyyy HH-mm";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_spending")
    private Date dateSpending;

    @Column(name = "topic")
    private String topic;

    @ManyToOne
    @JoinColumn(name = "organized_department_id")
    private Department department;

    @Column(name = "organized_employee")
    private String organizedEmployee;

    @ManyToMany
    @JoinTable(
            name = "participants",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer meetingID) {
        this.id = meetingID;
    }

    public String getDateSpending() {
        if (dateSpending != null) {
            return new SimpleDateFormat(PATTERN).format(dateSpending);
        }
        return "";
    }

    public void setDateSpending(String dateSpending) {
        try {
            this.dateSpending = new SimpleDateFormat(PATTERN).parse(dateSpending);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getOrganizedEmployee() {
        return organizedEmployee;
    }

    public void setOrganizedEmployee(String organizedEmployee) {
        this.organizedEmployee = organizedEmployee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}