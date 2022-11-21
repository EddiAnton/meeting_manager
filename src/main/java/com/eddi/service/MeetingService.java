package com.eddi.service;

import com.eddi.model.Meeting;
import com.eddi.model.Report;
import com.eddi.repository.MeetingRepo;
import com.eddi.repository.ReportRepo;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class MeetingService {
    private final MeetingRepo meetingRepo;

    private final ReportRepo reportRepo;

    public MeetingService(MeetingRepo meetingRepo, ReportRepo reportRepo) {
        this.meetingRepo = meetingRepo;
        this.reportRepo = reportRepo;
    }

    public void saveMeeting(Meeting meeting) {
        meetingRepo.save(meeting);
    }

    public void saveReport(Report report) {
        reportRepo.save(report);
    }

    public List<Meeting> getAllMeeting() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(meetingRepo.findAll().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public List<Report> getAllReport() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(reportRepo.findAll().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public Report getReportById(String reportId) {
        Integer id = Integer.parseInt(reportId);
        return reportRepo.findReportById(id);
    }

    public List<Meeting> findByTopicContainingAndDateSpendingBetween(String topic, String fromDate, String toDate) {
        Date from;
        Date to;
        try {
            from = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
        }
        catch (Exception e) {
            from = Date.from(Instant.ofEpochMilli(0));
        }
        try {
            to = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
        }
        catch (Exception e) {
            to = new Date(2050,1,1);
        }
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(meetingRepo.findByTopicContainingAndDateSpendingBetween(topic, from, to).iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public List<Meeting> findByEmployeesContaining(String participant) {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(meetingRepo.findByEmployeesContaining(participant).iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public List<Meeting> findByDepartmentNameContaining(String department) {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(meetingRepo.findByDepartmentNameContaining(department).iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }

    public List<Meeting> getLastMeeting() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(meetingRepo.findLastMeeting().iterator(),
                        Spliterator.NONNULL), false)
                .collect(Collectors.toList());
    }
}
