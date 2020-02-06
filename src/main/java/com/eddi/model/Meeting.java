package com.eddi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "date_spending")
    Date date_spending;

    @Column(name = "topic")
    String topic;

    @Column(name = "meeting_organizer")
    Integer meeting_organizer;

    @Column(name = "organized_employee")
    String organized_employee;
    /*
    List<Employee> participants;
    */
    public Integer getId() {
        return id;
    }

    public void setId(Integer meetingID) {
        this.id = meetingID;
    }

    public Date getDateSpending() {
        return date_spending;
    }

    public void setDateSpending(Date dateSpending) {
        this.date_spending = dateSpending;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getMeetingOrganizer() {
        return meeting_organizer;
    }

    public void setMeetingOrganizer(Integer meetingOrganizer) {
        this.meeting_organizer = meetingOrganizer;
    }

    public String getOrganizedEmployee() {
        return organized_employee;
    }

    public void setOrganizedEmployee(String organizedEmployee) {
        this.organized_employee = organizedEmployee;
    }

    /*public List<Employee> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Employee> participants) {
        this.participants = participants;
    }
    */
}