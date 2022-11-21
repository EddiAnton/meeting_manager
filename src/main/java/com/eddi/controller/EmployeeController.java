package com.eddi.controller;

import com.eddi.model.Employee;
import com.eddi.service.DepartmentService;
import com.eddi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/create_employee")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartment());
        return "/create_employee";
    }

    @RequestMapping(value = "/create_employee/submit", method = RequestMethod.POST)
    public String submitEmployee(@ModelAttribute Employee employee, Model model) {
        employeeService.saveEmployee(employee);
        model.addAttribute("employees", employeeService.getAllEmployeeDesc());
        return "/view_employee_list";
    }

    @RequestMapping(value = "/view_employee_list", method = RequestMethod.GET)
    public String viewEmployeeList(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "/view_employee_list";
    }
}
