package com.romz.pma.dao;

import com.romz.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author roman - Project project-management
 */
public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    List<Employee> findAll();
}
