package com.romz.pma.dao;

import com.romz.pma.dto.IEmployeeProject;
import com.romz.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author roman - Project project-management
 */
public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value = "SELECT e.FIRST_NAME , e.LAST_NAME , COUNT(pe.EMPLOYEE_ID) AS PROJECT_COUNT" +
            " FROM employee e LEFT JOIN project_employee pe ON e.EMPLOYEE_ID = pe.EMPLOYEE_ID" +
            " GROUP BY e.FIRST_NAME, e.LAST_NAME ORDER BY 3 DESC")
    List<IEmployeeProject> employeesProjects();
}
