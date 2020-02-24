package com.eddi.controller;

import com.eddi.model.Meeting;
import com.eddi.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String search(@RequestParam("topic") String topic, Model model) {
        model.addAttribute("meetings", meetingService.findByTitleContaining(topic));
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

