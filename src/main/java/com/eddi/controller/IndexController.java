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
@RequestMapping("index")
public class IndexController {

    @Autowired
    private MeetingService meetingService;

    @RequestMapping
    public String indexPageSearch(Model model) {
        model.addAttribute("message", "Search");
        return "index";
    }

    @RequestMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("meeting", new Meeting());
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String submitMeeting(@ModelAttribute Meeting meeting) {
        meetingService.save(meeting);
        return "redirect:../";
    }
}

