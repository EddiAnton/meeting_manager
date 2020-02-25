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
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/search_page")
public class SearchPageController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping
    public String mainPage(Model model) {
        return "search_page";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String search(@RequestParam("topic") String topic,
                         @RequestParam("organizedEmployee") String organizedEmployee,
                         @RequestParam("fromDate") String fromDate,
                         @RequestParam("toDate") String toDate,
                         @RequestParam("departmentName") String departmentName,
                         Model model) {
        ArrayList<Meeting> selection = new ArrayList<>();
        selection.addAll(meetingService.findByTitleContaining(topic));
        selection.addAll(meetingService.findByOrganizedEmployeeContaining(organizedEmployee));
        selection.addAll(meetingService.findByDateSpendingBetween(fromDate, toDate));
        selection.addAll(meetingService.findByDepartmentNameContaining(departmentName));
        model.addAttribute("meetings", selection);
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

