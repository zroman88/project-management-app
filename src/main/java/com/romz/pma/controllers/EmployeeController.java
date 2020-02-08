package com.romz.pma.controllers;

import com.romz.pma.entities.Employee;
import com.romz.pma.repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author roman - Project project-management
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    IEmployeeRepository repository;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "new-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(Employee employee, Model model) {
        repository.save(employee);

        return "redirect:/employees/new";
    }
}
