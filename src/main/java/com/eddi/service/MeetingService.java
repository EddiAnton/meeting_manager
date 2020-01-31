package com.eddi.service;

import com.eddi.model.Meeting;
import com.eddi.repository.MeetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void save(Meeting meeting) {
        Meeting savedMeeting = meetingRepo.save(meeting);
        System.out.println(savedMeeting.getMeetingID());
    }

    public List<Meeting> getAll() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(meetingRepo.findAll().iterator(),
                        Spliterator.NONNULL), false).collect(Collectors.toList());
    }
}
