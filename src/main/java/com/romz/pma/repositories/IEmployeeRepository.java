package com.romz.pma.repositories;

import com.romz.pma.entities.Employee;
import com.romz.pma.entities.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * @author roman - Project project-management
 */
public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
}
