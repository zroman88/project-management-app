package com.romz.pma.services;

import com.romz.pma.dao.IProjectRepository;
import com.romz.pma.dto.IProjectCount;
import com.romz.pma.entities.Project;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author roman - Project project-management
 */
@Service
public class ProjectService {
    IProjectRepository projectRepository;

    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public void save(Project project) {
        projectRepository.save(project);
    }

    public List<IProjectCount> projectsCount() {
        return projectRepository.projectsCount();
    }
}
