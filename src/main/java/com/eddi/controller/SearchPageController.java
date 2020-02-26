package com.eddi.controller;

import com.eddi.model.Meeting;
import com.eddi.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/search_page")
public class SearchPageController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("employees", meetingService.getAllEmployee());
        model.addAttribute("departments", meetingService.getAllDepartment());
        return "search_page";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String search(@RequestParam("topic") String topic,
                         @RequestParam("participant") String participant,
                         @RequestParam("fromDate") String fromDate,
                         @RequestParam("toDate") String toDate,
                         @RequestParam("departmentName") String departmentName,
                         Model model) {
        List<Meeting> allSelection = new ArrayList<>();
        List<Meeting> listFindOfTopicsAndDates;
        List<Meeting> listFindOfParticipants;
        List<Meeting> listFindOFDepartment;

        listFindOfTopicsAndDates = meetingService.findByTopicContainingAndDateSpendingBetween(topic, fromDate, toDate);
        listFindOfParticipants = meetingService.findByEmployeesContaining(participant);
        listFindOFDepartment = meetingService.findByDepartmentNameContaining(departmentName);

        if(allSelection.size() > 0 && listFindOfTopicsAndDates.size() > 0) {
            allSelection.retainAll(listFindOfTopicsAndDates);
        }else {
            allSelection.addAll(listFindOfTopicsAndDates);
        }
        if(allSelection.size() > 0 && listFindOfParticipants.size() > 0) {
            allSelection.retainAll(listFindOfParticipants);
        } else {
            allSelection.addAll(listFindOfParticipants);
        }
        if(allSelection.size() > 0 && listFindOFDepartment.size() > 0) {
            allSelection.retainAll(listFindOFDepartment);
        } else {
            allSelection.addAll(listFindOFDepartment);
        }

        model.addAttribute("meetings", allSelection);
        System.out.println(model);
        return "view_meeting_list";
    }

    @RequestMapping(value = "/view_meeting_list")
    public String getAllMeetings(Model model) {
        model.addAttribute("meetings", meetingService.getAllMeeting());
        model.addAttribute("employees", meetingService.getAllEmployee());
        model.addAttribute("departments", meetingService.getAllDepartment());
        return "view_meeting_list";
    }

    @RequestMapping(value = "/create_page")
    public String createPage(Model model) {
        model.addAttribute("meeting", new Meeting());
        model.addAttribute("employees", meetingService.getAllEmployee());
        model.addAttribute("departments", meetingService.getAllDepartment());
        return "create_page";
    }

    @RequestMapping(value = "/create_page/submit", method = RequestMethod.POST)
    public String submitMeeting(@ModelAttribute Meeting meeting) {
        meetingService.save(meeting);
        return "redirect:../";
    }
}

