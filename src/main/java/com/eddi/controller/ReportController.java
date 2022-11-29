package com.eddi.controller;

import com.eddi.model.Report;
import com.eddi.service.EmployeeService;
import com.eddi.service.ReportService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/index")
public class ReportController {

    private final EmployeeService employeeService;
    private final ReportService reportService;

    public ReportController(EmployeeService employeeService, ReportService reportService) {
        this.employeeService = employeeService;
        this.reportService = reportService;
    }

    @RequestMapping(value = "/create_report")
    @PreAuthorize("hasAuthority('report.create')")
    public String viewReport(Model model) {
        model.addAttribute("report", new Report());
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "/create_report";
    }

    @RequestMapping(value = "/create_report/submit", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('report.create')")
    public String createReport(@ModelAttribute Report report, Model model) {
        reportService.saveReport(report);
        model.addAttribute("reports", reportService.getAllReport());
        return "/view_report_list";
    }

    @RequestMapping(value = "/view_report_list", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('report.read')")
    public String getReportList(Model model) {
        model.addAttribute("reports", reportService.getAllReport());
        return "/view_report_list";
    }

    @RequestMapping(value = "/view_report_list/submit", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('report.read')")
    public String getContent(@RequestParam("reportId") String reportId, Model model) {
        model.addAttribute("report", reportService.getReportById(reportId));
        return "/view_report_content";
    }
}
