package com.romz.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.romz.pma.dto.IEmployeeProject;
import com.romz.pma.dto.IProjectCount;
import com.romz.pma.entities.Project;
import com.romz.pma.services.EmployeeService;
import com.romz.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author roman - Project project-management
 */
@Controller
public class HomeController {
    final ProjectService projectRepository;

    final EmployeeService employeeRepository;

    @Value(value = "${version}")
    private String version;

    public HomeController(ProjectService projectRepository, EmployeeService employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String getMapping(Model model) throws JsonProcessingException {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        List<IProjectCount> projectsCount = projectRepository.projectsCount();

        // Let's convert the data object into json for use with javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectsCount);

        // Send our json to the home page!
        model.addAttribute("projectStatusCnt", jsonString);

        List<IEmployeeProject> employeesProjectCnt = employeeRepository.employeesProjects();
        model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);

        // Grab configuration from our yaml file
        model.addAttribute("version", version);

        return "main/home";
    }
}
