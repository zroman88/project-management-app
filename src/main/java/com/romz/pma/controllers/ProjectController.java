package com.romz.pma.controllers;

import com.romz.pma.entities.Employee;
import com.romz.pma.entities.Project;
import com.romz.pma.dao.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author roman - Project project-management
 */
@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    IProjectRepository repository;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = repository.findAll();
        model.addAttribute("projects", projects);

        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectsForm(Model model) {
        Project aProject = new Project();
        model.addAttribute("project", aProject);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String saveProject(Project project, Model model) {
        repository.save(project);

        return "redirect:/projects/new";
    }
}
