package com.eddi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "meeting")
public class Meeting {
    private static final String PATTERN = "yyyy-MM-dd";

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "organized_employee_id")
    private Employee organizedEmployee;

    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;

    @ManyToMany
    @JoinTable(
            name = "participants",
            joinColumns = @JoinColumn(name = "meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;

    public Meeting() {}

    public Meeting(Integer id,
                   Date dateSpending,
                   String topic,
                   Department department,
                   Employee organizedEmployee,
                   Report report,
                   List<Employee> employees) {
        this.id = id;
        this.dateSpending = dateSpending;
        this.topic = topic;
        this.department = department;
        this.organizedEmployee = organizedEmployee;
        this.report = report;
        this.employees = employees;
    }

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

    public Employee getOrganizedEmployee() {
        return organizedEmployee;
    }

    public void setOrganizedEmployee(Employee organizedEmployee) {
        this.organizedEmployee = organizedEmployee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
