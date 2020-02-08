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
    Date dateSpending;

    @Column(name = "topic")
    String topic;

    @Column(name = "meeting_organizer")
    String meetingOrganizer;

    @Column(name = "organized_employee")
    String organizedEmployee;
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

    public String getMeetingOrganizer() {
        return meetingOrganizer;
    }

    public void setMeetingOrganizer(String meetingOrganizer) {
        this.meetingOrganizer = meetingOrganizer;
    }

    public String getOrganizedEmployee() {
        return organizedEmployee;
    }

    public void setOrganizedEmployee(String organizedEmployee) {
        this.organizedEmployee = organizedEmployee;
    }

    /*public List<Employee> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Employee> participants) {
        this.participants = participants;
    }
    */
}