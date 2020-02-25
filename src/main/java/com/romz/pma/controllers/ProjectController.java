package com.romz.pma.controllers;

import com.romz.pma.dao.IEmployeeRepository;
import com.romz.pma.entities.Employee;
import com.romz.pma.entities.Project;
import com.romz.pma.dao.IProjectRepository;
import com.romz.pma.services.EmployeeService;
import com.romz.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author roman - Project project-management
 */
@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectRepository;

    @Autowired
    EmployeeService empRepo;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectsForm(Model model) {
        Project aProject = new Project();
        model.addAttribute("project", aProject);


        List<Employee> allEmployees = empRepo.findAll();
        model.addAttribute("allEmployees", allEmployees);


        return "projects/new-project";
    }

    @PostMapping("/save")
    public String saveProject(Project project, Model model) {
        projectRepository.save(project);

        // Imtiaz's way
        // also have to add the @RequestParam Iterable<Long> employees above
//        Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);
//        for (Employee emp : chosenEmployees) {
//            emp.setProjects(project);
//            empRepo.save(emp);
//        }

//        List<Long> chosenEmployees = new ArrayList<>();
//
//        for (Employee emp : project.getEmployees())
//            chosenEmployees.add(emp.getEmployeeId());
//
//        for (Employee emp : empRepo.findAllById(chosenEmployees)) {
//            emp.setProjects(project);
//            empRepo.save(emp);
//        }
        return "redirect:/projects/new";
    }
}
