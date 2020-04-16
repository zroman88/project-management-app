package com.romz.pma.api.controllers;

import com.romz.pma.entities.Project;
import com.romz.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author roman - Project project-management
 */
@RestController
@RequestMapping("/app-api/projects")
@CrossOrigin(origins = "http://localhost:8080")
public class ProjectApiController {

        @Autowired
        ProjectService projectService;

        @GetMapping
        public Iterable<Project> getProjects() {
            return projectService.findAll();
        }

        @GetMapping("/{id}")
        public Project getProjectById(@PathVariable("id") Long id) {
            return projectService.findById(id).get();

        }

        @PostMapping(consumes = "application/json")
        @ResponseStatus(HttpStatus.CREATED)
        public Project create(@RequestBody Project project) {
            return projectService.save(project);
        }

        // Full update, will trigger cascading delete
        @PutMapping(consumes = "application/json")
        @ResponseStatus(HttpStatus.OK)
        public Project update(@RequestBody Project project) {
            return projectService.save(project);
        }

        // Partial update
        @PatchMapping(path = "/{id}", consumes = "application/json")
        @ResponseStatus(HttpStatus.OK)
        public Project patch(@PathVariable("id") Long id, @RequestBody Project patchProj) {
            Project project = projectService.findById(id).get();

            if (patchProj.getName() != null) {
                project.setName(patchProj.getName());
            }
            if (patchProj.getDescription() != null) {
                project.setDescription(patchProj.getDescription());
            }
            if (patchProj.getStage() != null) {
                project.setStage(patchProj.getStage());
            }
            if (patchProj.getEmployees() != null) {
                project.setEmployees(patchProj.getEmployees());
            }

            return projectService.save(project);
        }

        @DeleteMapping(value = "/{id}", consumes = "application/json")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable("id") Long id) {
            try {
                projectService.deleteById(id);
            } catch (EmptyResultDataAccessException e) {
                System.out.println(e.getMessage());
            }
        }
    }
