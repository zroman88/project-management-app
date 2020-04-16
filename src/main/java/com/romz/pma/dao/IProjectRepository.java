package com.romz.pma.dao;

import com.romz.pma.dto.IProjectCount;
import com.romz.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author roman - Project project-management
 */
public interface IProjectRepository extends CrudRepository<Project, Long> {

    @Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as value FROM project GROUP BY stage")
    List<IProjectCount> projectsCount();

}
