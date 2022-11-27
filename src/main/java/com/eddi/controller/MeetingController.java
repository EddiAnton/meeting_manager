package com.eddi.controller;

import com.eddi.model.Meeting;
import com.eddi.service.DepartmentService;
import com.eddi.service.EmailService;
import com.eddi.service.EmployeeService;
import com.eddi.service.MeetingService;
import com.eddi.service.ReportService;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class MeetingController {

    private final MeetingService meetingService;
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final ReportService reportService;
    private final EmailService emailService;

    public MeetingController(MeetingService meetingService, EmployeeService employeeService, DepartmentService departmentService, ReportService reportService, EmailService emailService) {
        this.meetingService = meetingService;
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.reportService = reportService;
        this.emailService = emailService;
    }

    @RequestMapping
    public String getLastMeetings(Model model) {
        model.addAttribute("meetings", meetingService.getLastMeeting());
        model.addAttribute("employees", employeeService.getAllEmployee());
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "/index";
    }

    @RequestMapping(value = "/administration")
    @PreAuthorize("hasAuthority('admin.view')")
    public String getAdministration() {
        return "/administration";
    }

    @RequestMapping(value = "/search_meeting")
    @PreAuthorize("hasAuthority('meeting.read')")
    public String mainPage(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "/search_meeting";
    }

    @RequestMapping(value = "/search_meeting/submit", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('meeting.read')")
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
    @PreAuthorize("hasAuthority('meeting.read')")
    public String getAllMeetings(Model model) {
        model.addAttribute("meetings", meetingService.getAllMeeting());
        model.addAttribute("employees", employeeService.getAllEmployee());
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "/view_meeting_list";
    }

    @RequestMapping(value = "/view_meeting_list/submit", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('meeting.read')")
    public String getAllMeetingEmployees(@RequestParam("meetingId") String meetingId, Model model) {
        model.addAttribute("participants", employeeService.findByMeetingAllEmployees(meetingId));
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "/view_participants_list";
    }

    @RequestMapping(value = "/create_meeting")
    @PreAuthorize("hasAuthority('meeting.create')")
    public String createMeeting(Model model) {
        model.addAttribute("meeting", new Meeting());
        model.addAttribute("employees", employeeService.getAllEmployee());
        model.addAttribute("departments", departmentService.getAllDepartment());
        model.addAttribute("reports", reportService.getAllReport());
        return "/create_meeting";
    }

    @RequestMapping(value = "/create_meeting/submit", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('meeting.create')")
    public String submitMeeting(@ModelAttribute Meeting meeting) {
        meetingService.saveMeeting(meeting);

//        TODO: не проходит авторизация, ошибка пользователя и пароля
//        List<Employee> participants = new ArrayList<>(meeting.getEmployees());
//        for(Employee participant: participants) {
//            String toEmail = participant.getEmail();
//            emailService.sendMail(toEmail, "New meeting", "You have a new meeting scheduled.");
//        }
        return "redirect:../";
    }
}
