package com.romz.pma.services;

import com.romz.pma.dao.IProjectRepository;
import com.romz.pma.dto.IProjectCount;
import com.romz.pma.entities.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author roman - Project project-management
 */
@Service
public class ProjectService {
    IProjectRepository projectRepository;

    public ProjectService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public List<IProjectCount> projectsCount() {
        return projectRepository.projectsCount();
    }

    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
}
