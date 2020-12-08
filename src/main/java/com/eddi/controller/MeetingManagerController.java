package com.eddi.controller;

import com.eddi.model.Employee;
import com.eddi.model.Meeting;
import com.eddi.model.Report;
import com.eddi.service.EmployeeService;
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
@RequestMapping("/index")
public class MeetingManagerController {

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping
    public String getLastMeetings(Model model) {
        model.addAttribute("meetings", meetingService.getAllMeeting());
        model.addAttribute("employees", meetingService.getAllEmployee());
        model.addAttribute("departments", meetingService.getAllDepartment());
        return "/index";
    }

    @RequestMapping(value = "/search_meeting")
    public String mainPage(Model model) {
        model.addAttribute("employees", meetingService.getAllEmployee());
        model.addAttribute("departments", meetingService.getAllDepartment());
        return "/search_meeting";
    }

    @RequestMapping(value = "/search_meeting/submit", method = RequestMethod.POST)
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
        return "/view_meeting_list";
    }

    @RequestMapping(value = "/view_meeting_list")
    public String getAllMeetings(Model model) {
        model.addAttribute("meetings", meetingService.getAllMeeting());
        model.addAttribute("employees", meetingService.getAllEmployee());
        model.addAttribute("departments", meetingService.getAllDepartment());
        return "/view_meeting_list";
    }

    @RequestMapping(value = "/view_meeting_list/submit", method = RequestMethod.POST)
    public String getAllMeetingEmployees(@RequestParam("meetingId") String meetingId, Model model) {
        model.addAttribute("participants", employeeService.findByMeetingAllEmployees(meetingId));
        model.addAttribute("departments", meetingService.getAllDepartment());
        return "/view_participants_list";
    }

    @RequestMapping(value = "/create_meeting")
    public String createPage(Model model) {
        model.addAttribute("meeting", new Meeting());
        model.addAttribute("employees", meetingService.getAllEmployee());
        model.addAttribute("departments", meetingService.getAllDepartment());
        model.addAttribute("reports", meetingService.getAllReport());
        return "/create_meeting";
    }

    @RequestMapping(value = "/create_meeting/submit", method = RequestMethod.POST)
    public String submitMeeting(@ModelAttribute Meeting meeting) {
        meetingService.saveMeeting(meeting);
        return "redirect:../";
    }

    @RequestMapping(value = "create_report")
    public String createReport(Model model) {
        model.addAttribute("report", new Report());
        model.addAttribute("employees", meetingService.getAllEmployee());
        return "/create_report";
    }

    @RequestMapping(value = "/create_report/submit", method = RequestMethod.POST)
    public String submitReport(@ModelAttribute Report report, Model model) {
        meetingService.saveReport(report);
        model.addAttribute("reports", meetingService.getAllReport());
        return "/view_report_list";
    }

    @RequestMapping(value = "create_employee")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", meetingService.getAllDepartment());
        return "/create_employee";
    }

    @RequestMapping(value = "create_employee/submit", method = RequestMethod.POST)
    public String submitEmployee(@ModelAttribute Employee employee) {
        meetingService.saveEmployee(employee);
        return "redirect:../";
    }
}

