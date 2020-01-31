package com.eddi.controller;

import com.eddi.model.Employee;
import com.eddi.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/index")
    public String index(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Iterable<Employee> employees = employeeRepo.findAll();

        model.addAttribute("employees", employees);
        return "create";
    }
}

