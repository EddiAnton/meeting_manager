package com.eddi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer meetingID;
    Date dateSpending;
    String topic;
    Department meetingOrganizer;
    Employee organizedEmployee;
    List<Employee> participants;

    public Integer getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(Integer meetingID) {
        this.meetingID = meetingID;
    }

    public Date getDateSpending() {
        return dateSpending;
    }

    public void setDateSpending(Date dateSpending) {
        this.dateSpending = dateSpending;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Department getMeetingOrganizer() {
        return meetingOrganizer;
    }

    public void setMeetingOrganizer(Department meetingOrganizer) {
        this.meetingOrganizer = meetingOrganizer;
    }

    public Employee getOrganizedEmployee() {
        return organizedEmployee;
    }

    public void setOrganizedEmployee(Employee organizedEmployee) {
        this.organizedEmployee = organizedEmployee;
    }

    public List<Employee> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Employee> participants) {
        this.participants = participants;
    }
}