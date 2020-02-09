package com.eddi.model;

import javax.persistence.*;
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