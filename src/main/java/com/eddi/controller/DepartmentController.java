package com.eddi.controller;

import com.eddi.model.Department;
import com.eddi.service.DepartmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/create_department")
    @PreAuthorize("hasAuthority('department.create')")
    public String viewDepartment(Model model) {
        model.addAttribute("department", new Department());
        return "/create_department";
    }

    @RequestMapping(value = "/create_department/submit", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('department.create')")
    public String createDepartment(@ModelAttribute Department department, Model model) {
        departmentService.saveDepartment(department);
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "/view_department_list";
    }

    @RequestMapping(value = "/view_department_list", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('department.read')")
    public String getDepartmentList(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "/view_department_list";
    }
}
