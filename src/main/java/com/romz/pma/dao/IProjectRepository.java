package com.romz.pma.dao;

import com.romz.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author roman - Project project-management
 */
public interface IProjectRepository extends CrudRepository<Project, Long> {
    @Override
    public List<Project> findAll();
}
