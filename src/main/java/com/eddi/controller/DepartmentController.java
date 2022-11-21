package com.eddi.controller;

import com.eddi.model.Department;
import com.eddi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/create_department")
    public String createDepartment(Model model) {
        model.addAttribute("department", new Department());
        return "/create_department";
    }

    @RequestMapping(value = "/create_department/submit", method = RequestMethod.POST)
    public String submitDepartment(@ModelAttribute Department department, Model model) {
        departmentService.saveDepartment(department);
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "/view_department_list";
    }

    @RequestMapping(value = "/view_department_list", method = RequestMethod.GET)
    public String viewDepartmentList(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "/view_department_list";
    }
}
