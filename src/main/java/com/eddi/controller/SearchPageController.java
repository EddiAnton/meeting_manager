package com.eddi.controller;

import com.eddi.model.Meeting;
import com.eddi.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/search_page")
public class SearchPageController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("message", "MainPage");
        return "search_page";
    }

    @RequestMapping(value = "/create_page")
    public String createPage(Model model) {
        model.addAttribute("meeting", new Meeting());
        return "create_page";
    }

    @RequestMapping(value = "/create_page/submit", method = RequestMethod.POST)
    public String submitMeeting(@ModelAttribute Meeting meeting) {
        meetingService.save(meeting);
        return "redirect:../";
    }
}

