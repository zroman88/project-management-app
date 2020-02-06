package com.romz.pma.repositories;

import com.romz.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author roman - Project project-management
 */
public interface IProjectRepository extends CrudRepository<Project, Long> {
}
