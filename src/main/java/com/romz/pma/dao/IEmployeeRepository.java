package com.romz.pma.dao;

import com.romz.pma.dto.IEmployeeProject;
import com.romz.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author roman - Project project-management
 */
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    @Query(nativeQuery = true, value = "SELECT e.FIRST_NAME , e.LAST_NAME , COUNT(pe.EMPLOYEE_ID) AS PROJECT_COUNT" +
            " FROM employee e LEFT JOIN project_employee pe ON e.EMPLOYEE_ID = pe.EMPLOYEE_ID" +
            " GROUP BY e.FIRST_NAME, e.LAST_NAME ORDER BY 3 DESC")
    List<IEmployeeProject> employeesProjects();

    public Employee findByEmail(String value);

//    public Employee findByEmployeeId(Long id);
}
