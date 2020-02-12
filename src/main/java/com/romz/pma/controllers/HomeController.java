package com.romz.pma.controllers;

import com.romz.pma.dto.IEmployeeProject;
import com.romz.pma.entities.Employee;
import com.romz.pma.entities.Project;
import com.romz.pma.dao.IEmployeeRepository;
import com.romz.pma.dao.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author roman - Project project-management
 */
@Controller
public class HomeController {
    @Autowired
    IProjectRepository projectRepository;

    @Autowired
    IEmployeeRepository employeeRepository;

    @GetMapping("/")
    public String getMapping(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        List<IEmployeeProject> employeesProjectCnt = employeeRepository.employeesProjects();
        model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);

        return "main/home";
    }
}
